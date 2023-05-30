package com.example.delivery_burgers.api.event;

import com.example.delivery_burgers.store.entity.CustomerEntity;
import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {
    private final CustomerEntity user;

    public UserRegisteredEvent(Object source, CustomerEntity user) {
        super(source);
        this.user = user;
    }

    public CustomerEntity getUser() {
        return user;
    }
}
