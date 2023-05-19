package com.example.delivery_burgers.service;

import com.example.delivery_burgers.dto.CustomerDto;
import com.example.delivery_burgers.mapper.CustomerMapper;
import com.example.delivery_burgers.model.Customer;
import com.example.delivery_burgers.repository.CustomerRepository;
import com.example.delivery_burgers.service.mail.UserEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository personRepository;
    private final CustomerMapper customerMapper;
    private final UserEventPublisher eventPublisher;

    public CustomerDto save(Customer customer) {
        Customer builder = Customer.builder()
                .username(customer.getUsername())
                .phoneNumber(customer.getPhoneNumber())
                .password(customer.getPassword())
                .build();
        Customer registered = personRepository.save(builder);
        eventPublisher.publishUserRegisteredEvent(registered);
        return customerMapper.toDto(registered);
    }
}
