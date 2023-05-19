package com.example.delivery_burgers.repository;

import com.example.delivery_burgers.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
