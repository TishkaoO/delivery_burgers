package com.example.delivery_burgers.event;

import com.example.delivery_burgers.model.Customer;
import org.springframework.context.ApplicationEvent;

//регистрирует событие
/*
является событием, возникающим при регистрации нового пользователя.
Он наследуется от класса `ApplicationEvent`,
который представляет базовый класс для всех событий в Spring Framework.
 */
public class UserRegisteredEvent extends ApplicationEvent {
    private final Customer user;

    /*
    Параметр `source` представляет объект,
    который инициировал событие, а параметр `user` представляет зарегистрированного пользователя.
     */

    /*
    Этот класс может быть использован для оповещения других компонентов приложения о том,
    что новый пользователь был зарегистрирован.
     Например, можно создать слушателя событий,
      который будет реагировать на это событие и выполнять какие-то действия,
      например, отправлять письмо с подтверждением регистраци
     */
    public UserRegisteredEvent(Object source, Customer user) {
        super(source);
        this.user = user;
    }

    public Customer getUser() {
        return user;
    }
}
