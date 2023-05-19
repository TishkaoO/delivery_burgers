package com.example.delivery_burgers.model;
import com.example.delivery_burgers.validation.Operation;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "burgers")
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
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

    @OneToMany(mappedBy = "burger")
    @NotEmpty(message = "Collection cannot be empty")
    @Size(min = 1, max = 10, message = "Collection size must be between {min} and {max}",
            groups = {Operation.OnUpdate.class,
            Operation.OnCreate.class, Operation.OnDelete.class})
    private List<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
