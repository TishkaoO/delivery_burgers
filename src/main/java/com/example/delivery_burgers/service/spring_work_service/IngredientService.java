package com.example.delivery_burgers.service.spring_work_service;

import com.example.delivery_burgers.dto.IngredientDto;
import com.example.delivery_burgers.model.Ingredient;
import com.example.delivery_burgers.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                () -> new IllegalArgumentException("ingredient is not exists"));
        return findOrder != null;
    }

    public boolean update(long id, IngredientDto dto) {
        var findIngredient = ingredientRepository.findById(id);
        if (!findIngredient.isEmpty()) {
            var ingredient = findIngredient.get();
            ingredient.setName(dto.getName());
            ingredient.setPrice(dto.getPrice());
            ingredient.setType(dto.getType());
            return true;
        }
        return false;
    }

    public Optional<IngredientDto> findById(long id) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        if (optionalIngredient.isPresent()) {
            Ingredient ingredient = optionalIngredient.get();
            IngredientDto dto = new IngredientDto();
            dto.setName(ingredient.getName());
            dto.setPrice(ingredient.getPrice());
            dto.setType(ingredient.getType());
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }

    public List<IngredientDto> findAll() {
        List<IngredientDto> listDto = new ArrayList<>();
        var findAll = ingredientRepository.findAll();
        for (Ingredient tmp : findAll) {
            IngredientDto dto = new IngredientDto();
            dto.setName(dto.getName());
            dto.setPrice(dto.getPrice());
            dto.setType(dto.getType());
            listDto.add(dto);
        }
        return listDto;
    }
}
