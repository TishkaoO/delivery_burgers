package com.example.delivery_burgers.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class OrderDto {

    @JsonProperty(namespace = "number_order")
    private int numberOrder;

    private List<BurgerDto> burgers;

    @JsonProperty(namespace = "created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Your_Timezone")
    private Instant createdDate = Instant.now();

    @JsonProperty(namespace = "status_order")
    private StatusOrderDto statusOrder;

    @JsonProperty(namespace = "to_pay")
    private double toPay;
}
