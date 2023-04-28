package com.example.delivery_burgers.service;

import com.example.delivery_burgers.model.Ingredient;

import java.util.Collection;
import java.util.Optional;

public interface IngredientService {

    boolean save(Ingredient ingredient);

    boolean deleteById(long id);

    boolean update(Ingredient ingredient);

    Optional<Ingredient> findById(long id);

    Collection<Ingredient> findAll();
}
