package com.example.desafio_spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long productId;
    @NotNull(message = "Name must not be null")
    private String name;
    @NotNull(message = "Category must not be null")
    private String category;
    @NotNull(message = "Brand must not be null")
    private String brand;
    @NotNull(message = "Price must not be null")
    private BigDecimal price;
    @NotNull(message = "Quantity must not be null")
    private Integer quantity;
    @NotNull(message = "FreeShipping must not be null")
    private Boolean freeShipping;
    @NotNull(message = "Prestige must not be null")
    private String prestige;
}
