package com.example.delivery_burgers.repository;

import com.example.delivery_burgers.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
