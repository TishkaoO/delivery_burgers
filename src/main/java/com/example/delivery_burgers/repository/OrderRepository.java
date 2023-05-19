package com.example.delivery_burgers.repository;

import com.example.delivery_burgers.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o JOIN o.customer c JOIN c.cards cd WHERE cd.number = :cardNumber")
    Optional<Order> findByCardNumber(@Param("cardNumber") String cardNumber);
}
