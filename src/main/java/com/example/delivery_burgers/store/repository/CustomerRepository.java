package com.example.delivery_burgers.store.repository;

import com.example.delivery_burgers.store.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findByUsername(String username);
}
