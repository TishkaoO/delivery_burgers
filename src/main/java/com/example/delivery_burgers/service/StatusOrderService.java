package com.example.delivery_burgers.service;

import com.example.delivery_burgers.dto.StatusOrderDto;
import com.example.delivery_burgers.mapper.StatusOrderMapper;
import com.example.delivery_burgers.repository.StatusOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatusOrderService {
    private final StatusOrderRepository statusRepository;
    private final StatusOrderMapper statusOrderMapper;

    public StatusOrderDto getStatusByNumberOrder(int number) {
        return statusRepository.findByNumberOrder(number)
                .map(order -> statusOrderMapper.toDto(order))
                .orElseThrow(() -> {
                    log.info("This status with number: " + number + " is not exists");
                    return new NoSuchElementException("Status is not exists");
                });
    }
}
