package com.example.delivery_burgers.service.spring_work_service;

import com.example.delivery_burgers.dto.IngredientDto;
import com.example.delivery_burgers.model.Ingredient;
import com.example.delivery_burgers.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public Ingredient save(IngredientDto dto) {
        return ingredientRepository.save(Ingredient.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .type(dto.getType())
                .build());
    }

    public boolean deleteById(long id) {
        var findOrder = ingredientRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("ingredient is not exists"));
        return findOrder != null;
    }

    public boolean update(long id, IngredientDto dto) {
        var ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ingredient with id " + id + " not found"));
        ingredient.setName(dto.getName());
        ingredient.setPrice(dto.getPrice());
        ingredient.setType(dto.getType());
        return true;
    }

    public IngredientDto findById(long id) {
        return ingredientRepository.findById(id)
                .map(ingredient -> new IngredientDto(
                        ingredient.getName(),
                        ingredient.getPrice(),
                        ingredient.getType())
                )
                .orElseThrow(() -> new NoSuchElementException("Ingredient with id " + id + " not found"));
    }

    public List<IngredientDto> findAll() {
        return ingredientRepository.findAll().stream()
                .map(ingredient -> new IngredientDto(
                        ingredient.getName(),
                        ingredient.getPrice(),
                        ingredient.getType())
                )
                .collect(Collectors.toList());
    }
}
