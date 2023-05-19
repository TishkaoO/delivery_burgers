package com.example.delivery_burgers.mapper;

import com.example.delivery_burgers.dto.OrderDto;
import com.example.delivery_burgers.dto.PaymentDto;
import com.example.delivery_burgers.model.Order;
import com.example.delivery_burgers.model.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDto toDto(Payment payment);

    Payment toEntity(PaymentDto dto);

    List<PaymentDto> toDto(List<Payment> payments);

    List<Payment> toEntity(List<PaymentDto> dtos);
}
