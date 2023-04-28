package com.example.delivery_burgers.service.spring_work_service;

import com.example.delivery_burgers.dto.BurgerOrderDto;
import com.example.delivery_burgers.model.BurgerOrder;
import com.example.delivery_burgers.repository.BurgerOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BurgerOrderService {
    private final BurgerOrderRepository burgerOrderRepository;

    public BurgerOrder save(BurgerOrderDto dto) {
        return burgerOrderRepository.save(BurgerOrder.builder()
                .deliveryAddress(dto.getDeliveryAddress())
                .burgers(dto.getBurgers())
                .creationDate(dto.getCreationDate())
                .isReady(dto.isReady())
                .build());
    }

    public boolean deleteById(long id) {
        var findOrder = burgerOrderRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("order is not exists"));
        return findOrder != null;
    }

    public boolean updateById(long id, BurgerOrderDto orderDto) {
        return burgerOrderRepository.findById(id)
                .map(order -> {
                    order.setDeliveryAddress(orderDto.getDeliveryAddress());
                    return true;
                })
                .orElse(false);
    }

    public BurgerOrderDto findById(long id) {
        return burgerOrderRepository.findById(id)
                .map(order -> new BurgerOrderDto(
                        order.getDeliveryAddress(),
                        order.getBurgers(),
                        order.getCreationDate(),
                        order.isReady()))
                .orElseThrow(() -> new IllegalArgumentException("order is not exists"));
    }

    public List<BurgerOrderDto> findAll() {
        return burgerOrderRepository.findAll().stream()
                .map(order -> new BurgerOrderDto(
                        order.getDeliveryAddress(),
                        order.getBurgers(),
                        order.getCreationDate(),
                        order.isReady()))
                .collect(Collectors.toList());
    }
}
