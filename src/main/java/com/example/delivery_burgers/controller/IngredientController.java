package com.example.delivery_burgers.controller;

import com.example.delivery_burgers.dto.IngredientDto;
import com.example.delivery_burgers.model.Ingredient;
import com.example.delivery_burgers.service.spring_work_service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping
    public List<IngredientDto> findAll() {
        return ingredientService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Ingredient> save(@RequestBody IngredientDto dto) {
        Ingredient ingredient = null;
        try {
            ingredient = ingredientService.save(dto);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to create ingredient");
        }
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/{id}")
    public IngredientDto findById(@PathVariable long id) {
        return ingredientService.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Ingredient is not found. Please, check that such a ingredient exists..."
        ));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IngredientDto> updateById(@PathVariable("id") long id, @RequestBody IngredientDto dto) {
        boolean isUpdated = ingredientService.update(id, dto);
        if (isUpdated) {
            IngredientDto updatedDto = ingredientService.findById(id).orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Ingredient is not found. Please, check that such a ingredient exists..."
            ));
            return ResponseEntity.ok(updatedDto);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        ingredientService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
