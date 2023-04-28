package com.example.delivery_burgers.repository;

import com.example.delivery_burgers.model.IngredientType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientTypeRepository extends JpaRepository<IngredientType, Long> {
}
