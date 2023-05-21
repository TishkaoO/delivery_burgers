package com.example.delivery_burgers.api.mapper;

import com.example.delivery_burgers.api.dto.CustomerDto;
import com.example.delivery_burgers.store.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(CustomerEntity user);

    CustomerEntity toEntity(CustomerDto dto);

    List<CustomerDto> toDto(List<CustomerEntity> users);

    List<CustomerEntity> toEntity(List<CustomerDto> dtos);
}
