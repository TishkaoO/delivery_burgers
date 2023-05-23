package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.api.dto.AscDto;
import com.example.delivery_burgers.api.dto.OrderDto;
import com.example.delivery_burgers.api.dto.StatusOrderDto;
import com.example.delivery_burgers.api.exceptions.BadRequestException;
import com.example.delivery_burgers.api.mapper.OrderMapper;
import com.example.delivery_burgers.api.mapper.StatusOrderMapper;
import com.example.delivery_burgers.store.entity.BurgerEntity;
import com.example.delivery_burgers.store.entity.CustomerEntity;
import com.example.delivery_burgers.store.entity.OrderEntity;
import com.example.delivery_burgers.store.entity.StatusOrderEntity;
import com.example.delivery_burgers.store.repository.CustomerRepository;
import com.example.delivery_burgers.store.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final BurgerService burgerService;
    private final CustomerRepository customerRepository;
    private final StatusOrderService statusOrderService;
    private final StatusOrderMapper statusOrderMapper;

    private int countNumberOrder = 1;

    public OrderDto createOrder(Long customerId, List<Long> burgerId) {
        List<BurgerEntity> burgerEntities = burgerId.stream()
                .map(id -> burgerService.getBurgerEntityByIdOrElseThrow(id))
                .collect(Collectors.toList());
        double totalAmount = burgerEntities.stream()
                .mapToDouble(BurgerEntity::getPrice)
                .sum();
        OrderEntity builder = OrderEntity.builder()
                .numberOrder(countNumberOrder++)
                .burgers(burgerEntities)
                .createdAt(Instant.now())
                .build();
        orderRepository.save(builder);
        StatusOrderEntity statusEntity = statusOrderService.getStatusByName("waiting for payment");
        linkOrderToStatusOrder(builder.getId(), statusEntity.getId());
        linkOrderToCustomer(customerId, builder.getId());
        OrderDto orderDto = orderMapper.toDto(builder);
        StatusOrderDto statusDto = statusOrderMapper.toDto(statusEntity);
        orderDto.setStatusOrder(statusDto);
        orderDto.setToPay(totalAmount);
        log.info("Order added!");
        return orderDto;
    }

    public AscDto deleteOrderById(Long id) {
        OrderEntity order = getOrderEntityByIdOrElseThrow(id);
        orderRepository.delete(order);
        return AscDto.builder()
                .answer("Order delete!")
                .build();
    }

    public OrderDto update(Long orderId, Long burgerId, int numberOfBurger) {
        OrderEntity order = getOrderEntityByIdOrElseThrow(orderId);
        BurgerEntity burger = burgerService.getBurgerEntityByIdOrElseThrow(burgerId);
        List<BurgerEntity> selectedBurgers = order.getBurgers().stream()
                .filter(nextBurger -> nextBurger.getId().equals(burger.getId()))
                .collect(Collectors.toList());
        if (numberOfBurger < 0) {
            throw new BadRequestException("Cannot pass a negative number of burgers");
        }
        if (selectedBurgers.size() == numberOfBurger) {
            throw new BadRequestException("Already have the specified number of burgers");
        }
        if (selectedBurgers.size() < numberOfBurger) {
            int additionalBurgers = numberOfBurger - selectedBurgers.size();
            for (int i = 0; i < additionalBurgers; i++) {
                order.getBurgers().add(burger);
            }
        } else {
            int remainingBurgers = selectedBurgers.size() - numberOfBurger;
            order.getBurgers().removeIf(selectedBurgers::contains);
        }
        double totalAmount = order.getBurgers().stream()
                .mapToDouble(BurgerEntity::getPrice)
                .sum();
        OrderDto dto = orderMapper.toDto(order);
        dto.setToPay(totalAmount);
        OrderEntity updatedOrder = orderRepository.save(order);
        return orderMapper.toDto(updatedOrder);
    }

    public OrderEntity getOrderEntityByIdOrElseThrow(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new BadRequestException("Order not found"));
        return order;
    }

    public void linkOrderToCustomer(Long customerId, Long orderId) {
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("customer not found"));
        OrderEntity order = getOrderEntityByIdOrElseThrow(orderId);
        customer.getOrders().add(order);
        orderRepository.save(order);
    }

    public void linkOrderToStatusOrder(Long orderId, Long statusId) {
        OrderEntity order = getOrderEntityByIdOrElseThrow(orderId);
        StatusOrderEntity statusOrder = statusOrderService.getStatusOrderEntityByIdOrElseThrow(statusId);
        statusOrder.getOrders().add(order);
        statusOrderService.save(statusOrder);
    }
}
