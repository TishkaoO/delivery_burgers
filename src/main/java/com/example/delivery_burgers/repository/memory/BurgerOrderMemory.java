package com.example.delivery_burgers.repository.memory;

import com.example.delivery_burgers.model.Burger;
import com.example.delivery_burgers.model.BurgerOrder;

import java.util.Collection;
import java.util.Optional;

public interface BurgerOrderMemory {

    boolean save(BurgerOrder order);

    boolean deleteById(long id);

    boolean update(BurgerOrder order);

    Optional<BurgerOrder> findById(long id);

    Collection<BurgerOrder> findAll();
}
