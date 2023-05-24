package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.api.dto.StatusOrderDto;
import com.example.delivery_burgers.api.exceptions.BadRequestException;
import com.example.delivery_burgers.api.mapper.StatusOrderMapper;
import com.example.delivery_burgers.store.entity.OrderEntity;
import com.example.delivery_burgers.store.entity.StatusOrderEntity;
import com.example.delivery_burgers.store.repository.StatusOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusOrderService {
    private final StatusOrderRepository statusOrderRepository;
    private final StatusOrderMapper statusOrderMapper;

    public void save(StatusOrderEntity entity) {
        statusOrderRepository.save(entity);
    }

    public StatusOrderEntity getStatusByName(String name) {
        return statusOrderRepository.findByName(name)
                .orElseThrow(() -> new BadRequestException("Status not found"));
    }

    public StatusOrderEntity getStatusOrderEntityByIdOrElseThrow(Long id) {
        return statusOrderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Status not found"));
    }

    public StatusOrderDto getStatusByNumberOrder(int numberOrder) {
        return statusOrderRepository.findByOrderNumber(numberOrder)
                .map(status -> statusOrderMapper.toDto(status))
                .orElseThrow(() -> new BadRequestException("status not found"));
    }

    public void removeOrderFromStatus(Long orderId) {
        StatusOrderEntity statusOrder = getStatusByName("waiting for payment");
        List<OrderEntity> orders = statusOrder.getOrders();
        orders.removeIf(order -> order.getId().equals(orderId));
        statusOrderRepository.save(statusOrder);
    }
}
