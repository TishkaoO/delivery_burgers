package com.example.delivery_burgers.service;

import com.example.delivery_burgers.dto.MenuDto;
import com.example.delivery_burgers.mapper.MenuMapper;
import com.example.delivery_burgers.model.Menu;
import com.example.delivery_burgers.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    public MenuDto getById(long id) {
        return menuRepository.findById(id)
                .map(menu -> menuMapper.toDto(menu))
                .orElseThrow(() -> {
                    log.info("This Menu with id: " + id + " is not exists");
                    return new NoSuchElementException("Menu is not exists");
                });
    }

    public List<MenuDto> getAll() {
        return menuRepository.findAll().stream()
                .map(menu -> menuMapper.toDto(menu))
                .collect(Collectors.toList());
    }
}
