package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.api.dto.BurgerDto;
import com.example.delivery_burgers.api.exceptions.BadRequestException;
import com.example.delivery_burgers.api.mapper.BurgerMapper;
import com.example.delivery_burgers.store.entity.BurgerEntity;
import com.example.delivery_burgers.store.repository.BurgerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BurgerService {
    private final BurgerRepository burgerRepository;
    private final BurgerMapper mapper;

    public BurgerEntity getBurgerEntityByIdOrElseThrow(Long dishId) {
        BurgerEntity entity = burgerRepository.findById(dishId)
                .orElseThrow(() -> new BadRequestException("Burger is not exists"));
        return entity;
    }
}
