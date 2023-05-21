package com.example.delivery_burgers.api.service.mail;

import com.example.delivery_burgers.api.event.UserRegisteredEvent;
import com.example.delivery_burgers.store.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEventPublisherImpl implements UserEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publishUserRegisteredEvent(CustomerEntity registeredUser) {
        eventPublisher.publishEvent(new UserRegisteredEvent(this, registeredUser));
    }
}
