package com.example.delivery_burgers.store.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ingredients_type")
public class IngredientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "ingredients_type_id", referencedColumnName = "id")
    private List<IngredientEntity> ingredients = new ArrayList<>();
}
