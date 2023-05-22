package com.example.delivery_burgers.store.entity;
import com.example.delivery_burgers.api.validation.Operation;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "burger")
public class BurgerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id must be non null", groups = {Operation.OnUpdate.class, Operation.OnDelete.class})
    private Long id;

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

    @Column(name = "is_spicy")
    private boolean isSpicy;
}
