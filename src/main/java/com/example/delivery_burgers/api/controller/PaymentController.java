package com.example.delivery_burgers.api.controller;

import com.example.delivery_burgers.api.dto.AscDto;
import com.example.delivery_burgers.api.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/to-pay/{orderId}")
    public AscDto payToTheOrder(@PathVariable Long orderId, @RequestParam Long cardId) {
        return paymentService.payToTheOrder(orderId, cardId);
    }
}
