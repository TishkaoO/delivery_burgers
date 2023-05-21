package com.example.delivery_burgers.api.service.mail;

import com.example.delivery_burgers.api.dto.WelcomeMailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailMessageSenderImpl implements MessageSender {
    private final JavaMailSender javaMailSender;

    @Override
    public String sendMessage(String email) {
        SimpleMailMessage simpleMailMessage =  new SimpleMailMessage();
        WelcomeMailDto dto = WelcomeMailDto.builder()
                .to(email)
                .subject("Whats up!!!")
                .text("welcome to delivery burgers!")
                .build();
        simpleMailMessage.setTo(dto.getTo());
        simpleMailMessage.setSubject(dto.getSubject());
        simpleMailMessage.setText(dto.getText());
        javaMailSender.send(simpleMailMessage);
        return "good mess!";
    }
}
