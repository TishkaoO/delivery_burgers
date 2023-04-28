package com.example.delivery_burgers.service.spring_work_service;

import com.example.delivery_burgers.dto.BurgerOrderDto;
import com.example.delivery_burgers.model.BurgerOrder;
import com.example.delivery_burgers.repository.BurgerOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public boolean updateById(long id, BurgerOrderDto order) {
        var findOrder = burgerOrderRepository.findById(id);
        if (!findOrder.isEmpty()) {
            var burgerOrder = findOrder.get();
            burgerOrder.setDeliveryAddress(order.getDeliveryAddress());
            return true;
        }
        return false;
    }

    public Optional<BurgerOrderDto> findById(long id) {
        var findOrder = burgerOrderRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("order is not exists"));
        BurgerOrderDto dto = new BurgerOrderDto();
        dto.setDeliveryAddress(findOrder.getDeliveryAddress());
        dto.setBurgers(findOrder.getBurgers());
        dto.setCreationDate(findOrder.getCreationDate());
        dto.setReady(findOrder.isReady());
        return Optional.ofNullable(dto);
    }

    public List<BurgerOrderDto> findAll() {
        List<BurgerOrderDto> dtoList = new ArrayList<>();
        var burgers = burgerOrderRepository.findAll();
        for (BurgerOrder burgerOrder : burgers) {
            BurgerOrderDto dto = new BurgerOrderDto();
            dto.setDeliveryAddress(burgerOrder.getDeliveryAddress());
            dto.setBurgers(burgerOrder.getBurgers());
            dto.setCreationDate(burgerOrder.getCreationDate());
            dto.setReady(burgerOrder.isReady());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
