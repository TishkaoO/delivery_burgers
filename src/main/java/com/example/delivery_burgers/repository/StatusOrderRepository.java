package com.example.delivery_burgers.repository;

import com.example.delivery_burgers.model.StatusOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StatusOrderRepository extends JpaRepository<StatusOrder, Long> {

    @Query("SELECT s FROM StatusOrder s WHERE EXISTS (SELECT o FROM Order o "
            + "WHERE o.statusOrder = s AND o.numberOrder = :numberOrder)")
    Optional<StatusOrder> findByNumberOrder(@Param("numberOrder") int number);
}
