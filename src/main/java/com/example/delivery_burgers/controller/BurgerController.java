package com.example.delivery_burgers.controller;

import com.example.delivery_burgers.dto.BurgerDto;
import com.example.delivery_burgers.model.Burger;
import com.example.delivery_burgers.service.spring_work_service.BurgerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/burgers")
@RequiredArgsConstructor
public class BurgerController {
    private final BurgerService burgerService;

    @GetMapping
    public List<BurgerDto> findAll() {
        return burgerService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Burger> save(@RequestBody BurgerDto dto) {
        Burger burger = null;
        try {
            burger = burgerService.save(dto);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to create burger");
        }
        return ResponseEntity.ok(burger);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BurgerDto> findById(@PathVariable long id) {
        var burgerDto = burgerService.findById(id);
        return ResponseEntity.ok(burgerDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BurgerDto> updateById(@PathVariable("id") long id, @RequestBody BurgerDto burgerDto) {
        boolean isUpdated = burgerService.updateById(id, burgerDto);
        if (isUpdated) {
            BurgerDto updatedDto = burgerService.findById(id);
            return ResponseEntity.ok(updatedDto);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        burgerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
