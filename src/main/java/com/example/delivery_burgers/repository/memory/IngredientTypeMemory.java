package com.example.delivery_burgers.repository.memory;

import com.example.delivery_burgers.model.IngredientType;

import java.util.Collection;
import java.util.Optional;

public interface IngredientTypeMemory {

    boolean save(IngredientType type);

    boolean deleteById(long id);

    boolean update(IngredientType type);

    Optional<IngredientType> findById(long id);

    Collection<IngredientType> findAll();
}
