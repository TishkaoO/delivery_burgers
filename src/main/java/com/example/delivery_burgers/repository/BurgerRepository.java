package com.example.delivery_burgers.repository;

import com.example.delivery_burgers.model.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerRepository extends JpaRepository<Burger, Long> {
}
