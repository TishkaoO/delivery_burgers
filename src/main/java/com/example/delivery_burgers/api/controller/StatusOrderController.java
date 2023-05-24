package com.example.delivery_burgers.api.controller;

import com.example.delivery_burgers.api.dto.StatusOrderDto;
import com.example.delivery_burgers.api.service.StatusOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/status")
public class StatusOrderController {
    private final StatusOrderService statusOrderService;

    @GetMapping("/check-status")
    public StatusOrderDto checkStatusOrder(@RequestParam int number) {
        return statusOrderService.getStatusByNumberOrder(number);
    }
}
