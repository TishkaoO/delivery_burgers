package com.example.delivery_burgers.store.repository;

import com.example.delivery_burgers.store.entity.StatusOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusOrderRepository extends JpaRepository<StatusOrderEntity, Long> {
    Optional<StatusOrderEntity> findByName(String name);
}
