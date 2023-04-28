package com.example.delivery_burgers.service.spring_work_service;

import com.example.delivery_burgers.dto.MenuDto;
import com.example.delivery_burgers.model.Menu;
import com.example.delivery_burgers.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        var findMenu = menuRepository.findById(id);
        if (!findMenu.isEmpty()) {
            var menu = findMenu.get();
            menu.setNameMenu(dto.getNameMenu());
            menu.setBurgers(dto.getBurgers());
            return true;
        }
        return false;
    }

    public Optional<MenuDto> findById(long id) {
        Optional<Menu> optionalMenu = menuRepository.findById(id);
        if (optionalMenu.isPresent()) {
            Menu menu = optionalMenu.get();
            MenuDto dto = new MenuDto();
            dto.setNameMenu(menu.getNameMenu());
            dto.setBurgers(menu.getBurgers());
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }

    public List<MenuDto> findAll() {
        List<MenuDto> listDto = new ArrayList<>();
        var findAll = menuRepository.findAll();
        for (Menu menu : findAll) {
            MenuDto dto = new MenuDto();
            dto.setNameMenu(menu.getNameMenu());
            dto.setBurgers(menu.getBurgers());
            listDto.add(dto);
        }
        return listDto;
    }
}
