package com.example.delivery_burgers.repository;

import com.example.delivery_burgers.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
