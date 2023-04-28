package com.example.delivery_burgers.service;

import com.example.delivery_burgers.model.Menu;

import java.util.Collection;
import java.util.Optional;

public interface MenuService {

    boolean save(Menu menu);

    boolean deleteById(long id);

    boolean update(Menu menu);

    Optional<Menu> findById(long id);

    Collection<Menu> findAll();
}
