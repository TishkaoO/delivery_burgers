package com.example.delivery_burgers.service.spring_work_service;

import com.example.delivery_burgers.dto.BurgerDto;
import com.example.delivery_burgers.model.Burger;
import com.example.delivery_burgers.repository.BurgerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BurgerService {
    private final BurgerRepository burgerRepository;


    public Burger save(BurgerDto dto) {
        return burgerRepository.save(Burger.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .isSpicy(dto.isSpicy())
                .ingredients(dto.getIngredients())
                .build());
    }

    public boolean deleteById(long id) {
        var findOrder = burgerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("burger is not exists"));
        return findOrder != null;
    }

    public boolean updateById(long id, BurgerDto burgerDto) {
        var burger = burgerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Burger with id " + id + " not found"));
        burger.setSpicy(burgerDto.isSpicy());
        burger.setIngredients(burgerDto.getIngredients());
        return true;
    }

    public BurgerDto findById(long id) {
        return burgerRepository.findById(id)
                .map(burger -> {
                    BurgerDto burgerDto = new BurgerDto();
                    burgerDto.setName(burger.getName());
                    burgerDto.setDescription(burger.getDescription());
                    burgerDto.setPrice(burger.getPrice());
                    return burgerDto;
                })
                .orElseThrow(() -> new IllegalArgumentException("Burger with id " + id + " is not found"));
    }

    public List<BurgerDto> findAll() {
        List<BurgerDto> listDto = new ArrayList<>();
        var burgerDto = burgerRepository.findAll().stream().map(tmp -> {
            BurgerDto dto = new BurgerDto();
            dto.setName(tmp.getName());
            dto.setPrice(tmp.getPrice());
            dto.setDescription(tmp.getDescription());
            return listDto.add(dto);
        }).collect(Collectors.toList());
        return listDto;
    }
}
