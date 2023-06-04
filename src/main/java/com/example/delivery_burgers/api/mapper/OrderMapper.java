package com.example.delivery_burgers.api.mapper;

import com.example.delivery_burgers.api.dto.OrderDto;
import com.example.delivery_burgers.store.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(OrderEntity entity);

    OrderEntity toEntity(OrderDto dto);

    List<OrderDto> toDto(List<OrderEntity> orders);

    List<OrderEntity> toEntity(List<OrderDto> dtos);
}
