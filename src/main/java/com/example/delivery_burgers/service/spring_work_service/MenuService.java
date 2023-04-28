package com.example.delivery_burgers.service.spring_work_service;

import com.example.delivery_burgers.dto.MenuDto;
import com.example.delivery_burgers.model.Menu;
import com.example.delivery_burgers.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public Menu save(MenuDto dto) {
        return menuRepository.save(Menu.builder()
                .nameMenu(dto.getNameMenu())
                .burgers(dto.getBurgers())
                .build());
    }

    public boolean deleteById(long id) {
        var findOrder = menuRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("menu is not exists"));
        return findOrder != null;
    }

    public boolean updateById(long id, MenuDto dto) {
        var menu = menuRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ingredient with id " + id + " not found"));
        menu.setNameMenu(dto.getNameMenu());
        menu.setBurgers(dto.getBurgers());
        return true;
    }

    public MenuDto findById(long id) {
        var menu = menuRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ingredient with id " + id + " not found"));
        MenuDto menuDto = new MenuDto();
        menuDto.setNameMenu(menu.getNameMenu());
        menuDto.setBurgers(menu.getBurgers());
        return menuDto;
    }

    public List<MenuDto> findAll() {
        List<MenuDto> listDto = new ArrayList<>();
        var findAll = menuRepository.findAll().stream()
                .map(menu -> {
                    MenuDto dto = new MenuDto();
                    dto.setNameMenu(menu.getNameMenu());
                    dto.setBurgers(menu.getBurgers());
                    return listDto.add(dto);
                });
        return listDto;
    }
}
