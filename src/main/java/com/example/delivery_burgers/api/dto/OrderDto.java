package com.example.delivery_burgers.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class OrderDto {

    private int numberOrder;

    private List<BurgerDto> burgers;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Your_Timezone")
    private Instant createdDate = Instant.now();

    private StatusOrderDto statusOrder;

    private double toPay;
}
