package com.example.delivery_burgers.api.mapper;

import com.example.delivery_burgers.api.dto.StatusOrderDto;
import com.example.delivery_burgers.store.entity.StatusOrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusOrderMapper {

    StatusOrderDto toDto(StatusOrderEntity statusOrder);

    StatusOrderEntity toEntity(StatusOrderDto dto);

    List<StatusOrderDto> toDto(List<StatusOrderEntity> statusOrders);

    List<StatusOrderEntity> toEntity(List<StatusOrderDto> dtos);
}
