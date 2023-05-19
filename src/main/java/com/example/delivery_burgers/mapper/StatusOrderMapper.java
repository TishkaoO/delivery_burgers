package com.example.delivery_burgers.mapper;

import com.example.delivery_burgers.dto.PaymentDto;
import com.example.delivery_burgers.dto.StatusOrderDto;
import com.example.delivery_burgers.model.Payment;
import com.example.delivery_burgers.model.StatusOrder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusOrderMapper {

    StatusOrderDto toDto(StatusOrder statusOrder);

    StatusOrder toEntity(StatusOrderDto dto);

    List<StatusOrderDto> toDto(List<StatusOrder> statusOrders);

    List<StatusOrder> toEntity(List<StatusOrderDto> dtos);
}
