package com.example.delivery_burgers.controller;

import com.example.delivery_burgers.dto.MenuDto;
import com.example.delivery_burgers.model.Menu;
import com.example.delivery_burgers.service.spring_work_service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menu")
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public List<MenuDto> findAll() {
        return menuService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Menu> save(@RequestBody MenuDto dto) {
        Menu menu = null;
        try {
            menu = menuService.save(dto);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to create menu");
        }
        return ResponseEntity.ok(menu);
    }

    @GetMapping("/{id}")
    public MenuDto findById(@PathVariable long id) {
        return menuService.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Menu is not found. Please, check that such a menu exists..."
        ));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MenuDto> updateById(@PathVariable("id") long id, @RequestBody MenuDto menuDto) {
        boolean isUpdated = menuService.updateById(id, menuDto);
        if (isUpdated) {
            MenuDto updatedDto = menuService.findById(id).orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Menu is not found. Please, check that such a menu exists..."
            ));
            return ResponseEntity.ok(updatedDto);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        menuService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
