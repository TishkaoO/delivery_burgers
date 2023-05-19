package com.example.delivery_burgers.event;

import com.example.delivery_burgers.model.Customer;
import com.example.delivery_burgers.service.mail.MessageSender;
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
        Customer user = event.getUser();
        String email = user.getUsername();
        messageSender.sendMessage(email);
    }
}
