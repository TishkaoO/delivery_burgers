package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.api.service.mail.UserEventPublisher;
import com.example.delivery_burgers.api.dto.CustomerDto;
import com.example.delivery_burgers.api.mapper.CustomerMapper;
import com.example.delivery_burgers.store.entity.CustomerEntity;
import com.example.delivery_burgers.store.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final UserEventPublisher eventPublisher;

    public CustomerDto save(CustomerEntity customer) {
        CustomerEntity builder = CustomerEntity.builder()
                .username(customer.getUsername())
                .phoneNumber(customer.getPhoneNumber())
                .password(customer.getPassword())
                .build();
        CustomerEntity registered = customerRepository.save(builder);
        eventPublisher.publishUserRegisteredEvent(registered);
        return customerMapper.toDto(registered);
    }

    public CustomerEntity getCustomerByIdOrElseThrow(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("customer not found"));
    }
}
