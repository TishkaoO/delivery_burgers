package com.example.delivery_burgers.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StatusOrderDto {

    private String name;

    private String description;
}
