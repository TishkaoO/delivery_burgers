package com.example.delivery_burgers.mapper;

import com.example.delivery_burgers.dto.MenuDto;
import com.example.delivery_burgers.dto.OrderDto;
import com.example.delivery_burgers.model.Menu;
import com.example.delivery_burgers.model.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(Order order);

    Order toEntity(OrderDto dto);

    List<OrderDto> toDto(List<Order> orders);

    List<Order> toEntity(List<OrderDto> dtos);
}
