package com.example.delivery_burgers.service.spring_work_service;

import com.example.delivery_burgers.dto.BurgerOrderDto;
import com.example.delivery_burgers.model.BurgerOrder;
import com.example.delivery_burgers.repository.BurgerOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
                .map(order -> {
                    BurgerOrderDto dto = new BurgerOrderDto();
                    dto.setDeliveryAddress(order.getDeliveryAddress());
                    dto.setBurgers(order.getBurgers());
                    dto.setCreationDate(order.getCreationDate());
                    dto.setReady(order.isReady());
                    return dto;
                })
                .orElseThrow(() -> new IllegalArgumentException("order is not exists"));
    }

    public List<BurgerOrderDto> findAll() {
        List<BurgerOrderDto> dtoList = new ArrayList<>();
        var burgers = burgerOrderRepository.findAll().stream()
                .map(order -> {
                    BurgerOrderDto dto = new BurgerOrderDto();
                    dto.setDeliveryAddress(order.getDeliveryAddress());
                    dto.setBurgers(order.getBurgers());
                    dto.setCreationDate(order.getCreationDate());
                    dto.setReady(order.isReady());
                    return dtoList.add(dto);
                });
        return dtoList;
    }
}
