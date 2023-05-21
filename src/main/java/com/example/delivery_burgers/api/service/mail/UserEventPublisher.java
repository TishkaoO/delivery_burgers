package com.example.delivery_burgers.api.service.mail;

import com.example.delivery_burgers.store.entity.CustomerEntity;

public interface UserEventPublisher {
    void publishUserRegisteredEvent(CustomerEntity registeredUser);
}
