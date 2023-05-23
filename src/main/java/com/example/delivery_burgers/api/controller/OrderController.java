package com.example.delivery_burgers.api.controller;

import com.example.delivery_burgers.api.dto.OrderDto;
import com.example.delivery_burgers.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public OrderDto createOrder(@PathVariable("user_id") Long userId, @RequestParam("burger_id") List<Long> burgersId) {
        return orderService.createOrder(userId, burgersId);
    }

    @PatchMapping("/{order_id}")
    public OrderDto update(@PathVariable("order_id") Long orderId, @RequestParam("burger_id") Long burgerId,
                           @RequestParam("number") int numberOfBurger) {
        return orderService.update(orderId, burgerId, numberOfBurger);

        //TODO: решить проблему с методом не корректно обновляет а точнее перебивает стоимость на 0
    }
}
