package com.example.delivery_burgers.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WelcomeMailDto {

    private String to;

    private String subject;

    private String text;
}
