package com.example.delivery_burgers.controller;

import com.example.delivery_burgers.dto.BurgerOrderDto;
import com.example.delivery_burgers.model.BurgerOrder;
import com.example.delivery_burgers.service.spring_work_service.BurgerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class BurgerOrderController {

    private final BurgerOrderService burgerOrderService;

    @GetMapping
    public List<BurgerOrderDto> findAll() {
        return burgerOrderService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<BurgerOrder> save(@RequestBody BurgerOrderDto dto) {
        BurgerOrder order = null;
        try {
            order = burgerOrderService.save(dto);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to create order");
        }
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{id}")
    public BurgerOrderDto findById(@PathVariable long id) {
        return burgerOrderService.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Order is not found. Please, check that such a order exists..."
        ));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BurgerOrderDto> updateById(@PathVariable("id") long id, @RequestBody BurgerOrderDto dto) {
        boolean isUpdated = burgerOrderService.updateById(id, dto);
        if (isUpdated) {
            BurgerOrderDto updatedDto = burgerOrderService.findById(id).orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Order is not found. Please, check that such a order exists..."
            ));
            return ResponseEntity.ok(updatedDto);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        burgerOrderService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
