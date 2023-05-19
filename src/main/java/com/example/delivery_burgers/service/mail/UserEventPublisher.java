package com.example.delivery_burgers.service.mail;

import com.example.delivery_burgers.model.Customer;

public interface UserEventPublisher {
    void publishUserRegisteredEvent(Customer registeredUser);
}
