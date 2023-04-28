package com.example.delivery_burgers.repository.memory;

import com.example.delivery_burgers.model.Burger;
import com.example.delivery_burgers.model.Menu;

import java.util.Collection;
import java.util.Optional;

public interface MenuMemory {

    boolean save(Menu menu);

    boolean deleteById(long id);

    boolean update(Menu menu);

    Optional<Menu> findById(long id);

    Collection<Menu> findAll();
}
