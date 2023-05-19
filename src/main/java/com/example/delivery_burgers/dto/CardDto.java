package com.example.delivery_burgers.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CardDto {

    private String nameOwner;

    private String cardNumber;

    private LocalDateTime expiryDate;

    private String cvv;
}
