package com.example.desafio_spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long customerId;
    private String name;
    private String cpf;
    private String city;
    private String state;
    private String email;
    private String password;
}
