package com.example.delivery_burgers.repository.memory;

import com.example.delivery_burgers.model.BurgerOrder;
import com.example.delivery_burgers.model.Ingredient;

import java.util.Collection;
import java.util.Optional;

public interface IngredientMemory {

    boolean save(Ingredient ingredient);

    boolean deleteById(long id);

    boolean update(Ingredient ingredient);

    Optional<Ingredient> findById(long id);

    Collection<Ingredient> findAll();
}
