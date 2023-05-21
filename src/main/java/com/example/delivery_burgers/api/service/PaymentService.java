package com.example.delivery_burgers.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final OrderService orderService;
    private final CardService cardService;

//    public boolean payForTheOrder(CardEntity cardPay) {
//        CardEntity card = cardService.getCardByCardNumber(cardPay.getNumber());
//        Order order = orderService.getOrderByCardNumber(cardPay.getNumber());
//        if (!card.getCustomer().getPhoneNumber().equals(order.getCustomer().getPhoneNumber())) {
//            return false;
//        }
//        if (card.getBalance() < order.getPayment().getPaymentAmount()) {
//            return false;
//        }
//        card.setBalance(card.getBalance() - order.getPayment().getPaymentAmount());
//        cardService.update(card);
//        order.setStatusOrder(StatusOrderEntity.builder()
//                .name("In Progress")
//                .description("The order is being prepared.")
//                .build());
//        orderService.update(order);
//        log.info("order payment was successful");
//        return true;
//    }
}
