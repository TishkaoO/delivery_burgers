package com.example.delivery_burgers.api.controller;

import com.example.delivery_burgers.api.dto.CardDto;
import com.example.delivery_burgers.api.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    @PostMapping("/create/card-customer/{customer_id}")
    public CardDto createCard(@PathVariable("customer_id") Long customerId,
                              @RequestParam("name_owner") String nameOwner,
                              @RequestParam("card_number") String cardNumber,
                              @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")@RequestParam("expiry_date") LocalDateTime expiryDate, @RequestParam("cvv") String cvv) {
        return cardService.createCard(customerId, nameOwner, cardNumber,
                expiryDate, cvv);
    }
}
