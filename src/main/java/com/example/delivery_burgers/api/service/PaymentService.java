package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.api.dto.AscDto;
import com.example.delivery_burgers.api.exceptions.PaymentException;
import com.example.delivery_burgers.api.mapper.OrderMapper;
import com.example.delivery_burgers.store.entity.BurgerEntity;
import com.example.delivery_burgers.store.entity.CardEntity;
import com.example.delivery_burgers.store.entity.OrderEntity;
import com.example.delivery_burgers.store.entity.StatusOrderEntity;
import com.example.delivery_burgers.store.repository.CustomerRepository;
import com.example.delivery_burgers.store.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final OrderService orderService;
    private final CardService cardService;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;
    private final StatusOrderService statusOrderService;

    public AscDto payToTheOrder(Long orderId, Long cardId) {
        OrderEntity order = orderService.getOrderEntityByIdOrElseThrow(orderId);
        CardEntity card = cardService.getCardById(cardId);
        StatusOrderEntity status = statusOrderService.getStatusByName("order has been paid");
        double debit = 0;
        LocalDateTime currentDateTime = LocalDateTime.now();
        List<BurgerEntity> burgerEntities = order.getBurgers();
        double totalAmountOfTheOrder = burgerEntities.stream()
                .mapToDouble(BurgerEntity::getPrice)
                .sum();
        if(card.getExpiryDate().isBefore(currentDateTime)) {
            throw new PaymentException("The card has expired.");
        }
        if (totalAmountOfTheOrder <= card.getBalance()) {
            debit = card.getBalance() - totalAmountOfTheOrder;
            card.setBalance(debit);
            cardService.saveCard(card);
            statusOrderService.removeOrderFromStatus(orderId);
            orderService.linkOrderToStatusOrder(orderId, status.getId());
            return AscDto.builder()
                    .answer("payment was successful!")
                    .build();
        }
        throw new PaymentException("insufficient funds");
    }
}
