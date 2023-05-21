package com.example.delivery_burgers.store.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.delivery_burgers.api.validation.Operation;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    @NotNull(message = "Email must be not empty")
    @Size(min = 5, max = 40, message = "Email must be greater than 5 or less than 10", groups = {Operation.OnUpdate.class,
            Operation.OnCreate.class})
    @Email(regexp = ".+[@].+[\\.].+", message = "Email must contain only letters and numbers", groups = {Operation.OnCreate.class, Operation.OnUpdate.class})
    private String username;

    @NotNull(message = "Password must be not empty")
    @Size(min = 8, max = 50, message = "Password length must be smaller than 255", groups = {Operation.OnUpdate.class,
            Operation.OnDelete.class, Operation.OnCreate.class})
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private List<OrderEntity> orders = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Set<CardEntity> cards = new HashSet<>();
}
