package com.example.delivery_burgers.controller;

import com.example.delivery_burgers.dto.CustomerDto;
import com.example.delivery_burgers.dto.OrderDto;
import com.example.delivery_burgers.dto.StatusOrderDto;
import com.example.delivery_burgers.model.Card;
import com.example.delivery_burgers.model.Customer;
import com.example.delivery_burgers.model.Order;
import com.example.delivery_burgers.service.CustomerService;
import com.example.delivery_burgers.service.OrderService;
import com.example.delivery_burgers.service.PaymentService;
import com.example.delivery_burgers.service.StatusOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class CustomerController {
    private final ObjectMapper objectMapper;
    private final CustomerService personService;
    private final BCryptPasswordEncoder encoder;
    private final OrderService orderService;
    private final PaymentService paymentService;
    private final StatusOrderService statusOrderService;

    @PostMapping("/sign-up")
    public ResponseEntity<CustomerDto> signUp(@RequestBody Customer person) {
        person.setPassword(encoder.encode(person.getPassword()));
        var entity = ResponseEntity.status(HttpStatus.CREATED)
                .header("CustomHeader")
                .contentType(MediaType.APPLICATION_JSON)
                .body(personService.save(person));
        return entity;
    }

    @PostMapping("/create-order")
    public ResponseEntity<OrderDto> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/pay")
    public ResponseEntity<Boolean> payForTheOrder(@RequestBody Card card) {
        boolean status =  paymentService.payForTheOrder(card);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @PostMapping("/order/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable long id) {
        OrderDto order = orderService.getOrderById(id);
        return ResponseEntity
                .status(order != null ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @GetMapping("/check-status")
    public StatusOrderDto checkStatusOrder(@RequestParam int number) {
        return statusOrderService.getStatusByNumberOrder(number);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public void handleException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(new HashMap<>() {
            {
                put("message", e.getMessage());
                put("type", e.getClass());
            }
        }));
        log.error(e.getMessage());
    }
}
