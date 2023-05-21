package com.example.delivery_burgers.api.event;

import com.example.delivery_burgers.store.entity.CustomerEntity;
import com.example.delivery_burgers.api.service.mail.MessageSender;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredEventListener {
    private final MessageSender messageSender;

    public UserRegisteredEventListener(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    /*
    Аннотация `@EventListener` указывает, что метод `handleUserRegisteredEvent
    ` является обработчиком событий и будет вызываться при возникновении события `UserRegisteredEvent`.
     */
    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        CustomerEntity user = event.getUser();
        String email = user.getUsername();
        messageSender.sendMessage(email);
    }
}
