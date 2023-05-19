package com.example.delivery_burgers.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class AppConfig {

    @Value("${spring.mail.host}")
    private String mailHost;

    @Value("${spring.mail.port}")
    private String mailPort;

    @Value("${spring.mail.username}")
    private String mailUsername;

    @Value("${spring.mail.password}")
    private String mailPassword;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mailHost);
        javaMailSender.setPort(Integer.parseInt(mailPort));
        javaMailSender.setUsername(mailUsername);
        javaMailSender.setPassword(mailPassword);
        Properties props = javaMailSender.getJavaMailProperties();
        //Эта настройка включает использование STARTTLS (Transport Layer Security)
        // для защиты соединения при отправке электронной почты через SMTP-сервер.
        // STARTTLS - это протокол, который позволяет обеспечить безопасность передачи
        // данных между клиентом и сервером, используя шифрование.
        // Когда эта настройка установлена в "true",
        // JavaMail будет использовать STARTTLS для защиты соединения
        // при отправке электронной почты через SMTP-сервер.
        props.put("mail.smtp.starttls.enable", "true");
        return javaMailSender;
    }
}
