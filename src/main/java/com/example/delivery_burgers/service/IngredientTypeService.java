package com.example.delivery_burgers.service;

import com.example.delivery_burgers.model.IngredientType;

import java.util.Collection;
import java.util.Optional;

public interface IngredientTypeService {

    boolean save(IngredientType type);

    boolean deleteById(long id);

    boolean update(IngredientType type);

    Optional<IngredientType> findById(long id);

    Collection<IngredientType> findAll();
}
