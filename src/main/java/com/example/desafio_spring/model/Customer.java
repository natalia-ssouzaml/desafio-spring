package com.example.desafio_spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long customerId;
    @NotNull(message = "Name must not be null")
    private String name;
    @NotNull(message = "Cpf must not be null")
    private String cpf;
    @NotNull(message = "City must not be null")
    private String city;
    @NotNull(message = "State must not be null")
    private String state;
    @NotNull(message = "Email must not be null")
    @Email(message = "Email must be in this format: example@example.com")
    private String email;
    @NotNull(message = "Password must not be null")
    @Size(min = 6, max = 12, message = "The password must be between 6 to 12 characters")
    private String password;
    private List<Purchase> purchaseList;
}
