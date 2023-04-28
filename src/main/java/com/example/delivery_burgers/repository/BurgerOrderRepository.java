package com.example.delivery_burgers.repository;

import com.example.delivery_burgers.model.BurgerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerOrderRepository extends JpaRepository<BurgerOrder, Long> {
}
