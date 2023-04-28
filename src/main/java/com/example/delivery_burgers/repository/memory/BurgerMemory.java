package com.example.delivery_burgers.repository.memory;

import com.example.delivery_burgers.model.Burger;

import java.util.Collection;
import java.util.Optional;

public interface BurgerMemory {

    Optional<Burger> findByName(String name);

    boolean save(Burger burger);

    boolean deleteById(long id);

    boolean update(Burger burger);

    Optional<Burger> findById(long id);

    Collection<Burger> findAll();
}
