package com.example.delivery_burgers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardPayment {
    private Long id;
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private int cvv;
    private Date date;
    private int amount;
}
