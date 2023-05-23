package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.store.entity.BurgerEntity;
import com.example.delivery_burgers.store.repository.BurgerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BurgerService {
    private final BurgerRepository burgerRepository;

    public BurgerEntity getBurgerEntityByIdOrElseThrow(Long dishId) {
        BurgerEntity entity = burgerRepository.findById(dishId)
                .orElseThrow(() -> new IllegalArgumentException("Dish is not exists"));
        return entity;
    }
}
