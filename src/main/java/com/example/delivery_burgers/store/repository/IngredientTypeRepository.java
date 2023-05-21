package com.example.delivery_burgers.store.repository;

import com.example.delivery_burgers.store.entity.IngredientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientTypeRepository extends JpaRepository<IngredientType, Long> {
}
