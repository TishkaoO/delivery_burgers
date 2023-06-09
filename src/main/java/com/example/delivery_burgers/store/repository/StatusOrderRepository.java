package com.example.delivery_burgers.store.repository;

import com.example.delivery_burgers.store.entity.StatusOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusOrderRepository extends JpaRepository<StatusOrderEntity, Long> {
    Optional<StatusOrderEntity> findByName(String name);

    @Query("SELECT so FROM StatusOrderEntity so JOIN so.orders o WHERE o.numberOrder = :numberOder")
    Optional<StatusOrderEntity> findByOrderNumber(@Param("numberOder") int numberOrder);
}
