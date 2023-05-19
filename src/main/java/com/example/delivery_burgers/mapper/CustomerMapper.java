package com.example.delivery_burgers.mapper;

import com.example.delivery_burgers.dto.CustomerDto;
import com.example.delivery_burgers.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer user);

    Customer toEntity(CustomerDto dto);

    List<CustomerDto> toDto(List<Customer> users);

    List<Customer> toEntity(List<CustomerDto> dtos);
}
