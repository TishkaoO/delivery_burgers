package com.example.delivery_burgers.service;

import com.example.delivery_burgers.model.BurgerOrder;

import java.util.Collection;
import java.util.Optional;

public interface BurgerOrderService {

    boolean save(BurgerOrder order);

    boolean deleteById(long id);

    boolean update(BurgerOrder order);

    Optional<BurgerOrder> findById(long id);

    Collection<BurgerOrder> findAll();
}
