package com.example.delivery_burgers.api.dto;

import com.example.delivery_burgers.api.validation.Operation;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CustomerDto {

    @NotNull(message = "Email must be not empty")
    @Size(min = 5, max = 40, message = "Email must be greater than 5 or less than 10", groups = {Operation.OnUpdate.class,
            Operation.OnCreate.class})
    @Email(regexp = ".+[@].+[\\.].+", message = "Email must contain only letters and numbers", groups = {Operation.OnCreate.class, Operation.OnUpdate.class})
    private String username;

    @NotNull(message = "Password must be not empty")
    @Size(min = 8, max = 50, message = "Password length must be smaller than 255", groups = {Operation.OnUpdate.class,
            Operation.OnDelete.class, Operation.OnCreate.class})
    private String password;

    private String phoneNumber;
}
