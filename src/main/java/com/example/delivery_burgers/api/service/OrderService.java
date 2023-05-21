package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.api.dto.AscDto;
import com.example.delivery_burgers.api.dto.OrderDto;
import com.example.delivery_burgers.api.mapper.OrderMapper;
import com.example.delivery_burgers.store.entity.BurgerEntity;
import com.example.delivery_burgers.store.entity.OrderEntity;
import com.example.delivery_burgers.store.repository.BurgerRepository;
import com.example.delivery_burgers.store.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final BurgerRepository burgerRepository;

    private int countNumberOrder = 1;

    public OrderDto createOrder(List<Long> burgerId) {
        List<BurgerEntity> burgerEntities = burgerId.stream()
                .map(id -> burgerRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException()))
                .collect(Collectors.toList());
        double totalAmount = burgerEntities.stream()
                .mapToDouble(BurgerEntity::getPrice)
                .sum();
        OrderEntity builder = OrderEntity.builder()
                .numberOrder(countNumberOrder++)
                .burgers(burgerEntities)
                .build();
        orderRepository.saveAndFlush(builder);
        log.info("Order added!");
        OrderDto orderDto = orderMapper.toDto(builder);
        orderDto.setToPay(totalAmount);
        return orderDto;
    }

    public AscDto deleteOrderById(Long id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        orderRepository.delete(order);
        return AscDto.builder()
                .answer("it's GOOD!")
                .build();
    }

    public OrderDto update(Long orderId, Long burgerId, int numberOfBurger) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        BurgerEntity burger = burgerRepository.findById(burgerId)
                .orElseThrow(() -> new IllegalArgumentException("Burger not found"));
        List<BurgerEntity> selectedBurgers = order.getBurgers().stream()
                .filter(nextBurger -> nextBurger.getId().equals(burger.getId()))
                .collect(Collectors.toList());
        if (numberOfBurger < 0) {
            throw new IllegalArgumentException("Cannot pass a negative number of burgers");
        }
        if (selectedBurgers.size() == numberOfBurger) {
            throw new IllegalArgumentException("Already have the specified number of burgers");
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
}
