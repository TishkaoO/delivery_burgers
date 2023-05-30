package com.example.delivery_burgers.store.repository;

import com.example.delivery_burgers.store.entity.BurgerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BurgerRepository extends JpaRepository<BurgerEntity, Long> {
    Optional<BurgerEntity> findByName(String name);
}
