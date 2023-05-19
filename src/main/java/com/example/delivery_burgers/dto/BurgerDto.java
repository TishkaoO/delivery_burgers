package com.example.delivery_burgers.dto;

import com.example.delivery_burgers.model.Ingredient;
import com.example.delivery_burgers.validation.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class BurgerDto {

    @NotBlank(message = "Name must be not empty")
    @Length(max = 50, message = "Name length must be smaller than 50", groups = {Operation.OnUpdate.class,
            Operation.OnCreate.class})
    private String name;

    @NotBlank(message = "Description must be not empty")
    @Length(max = 255, message = "Description length must be smaller than 255", groups = {Operation.OnUpdate.class,
            Operation.OnDelete.class})
    private String description;

    @Min(value = 1, message = "Price must be more than 0", groups = {Operation.OnUpdate.class,
            Operation.OnCreate.class})
    private double price;

    private boolean isSpicy;

    @NotEmpty(message = "Collection cannot be empty")
    @Size(min = 1, max = 10, message = "Collection size must be between {min} and {max}", groups = {Operation.OnUpdate.class,
            Operation.OnCreate.class, Operation.OnDelete.class})
    private List<Ingredient> ingredients;
}
