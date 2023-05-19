package com.example.delivery_burgers.service.mail;

import com.example.delivery_burgers.event.UserRegisteredEvent;
import com.example.delivery_burgers.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEventPublisherImpl implements UserEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publishUserRegisteredEvent(Customer registeredUser) {
        eventPublisher.publishEvent(new UserRegisteredEvent(this, registeredUser));
    }
}
