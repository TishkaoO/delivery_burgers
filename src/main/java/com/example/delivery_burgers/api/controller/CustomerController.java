package com.example.delivery_burgers.api.controller;

import com.example.delivery_burgers.api.dto.CustomerDto;
import com.example.delivery_burgers.api.dto.OrderDto;
import com.example.delivery_burgers.store.entity.CustomerEntity;
import com.example.delivery_burgers.api.service.CustomerService;
import com.example.delivery_burgers.api.service.OrderService;
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

    @PostMapping("/sign-up")
    public ResponseEntity<CustomerDto> signUp(@RequestBody CustomerEntity person) {
        person.setPassword(encoder.encode(person.getPassword()));
        var entity = ResponseEntity.status(HttpStatus.CREATED)
                .header("CustomHeader")
                .contentType(MediaType.APPLICATION_JSON)
                .body(personService.save(person));
        return entity;
    }



//    @GetMapping("/check-status")
//    public StatusOrderDto checkStatusOrder(@RequestParam int number) {
//        return statusOrderService.getStatusByNumberOrder(number);
//    } TODO:Доделать проверку статуса заказ

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
