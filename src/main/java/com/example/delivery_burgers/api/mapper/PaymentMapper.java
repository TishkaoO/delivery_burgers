package com.example.delivery_burgers.api.mapper;

import com.example.delivery_burgers.api.dto.PaymentDto;
import com.example.delivery_burgers.store.entity.PaymentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDto toDto(PaymentEntity payment);

    PaymentEntity toEntity(PaymentDto dto);

    List<PaymentDto> toDto(List<PaymentEntity> payments);

    List<PaymentEntity> toEntity(List<PaymentDto> dtos);
}
