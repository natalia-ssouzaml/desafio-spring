package com.example.desafio_spring.dto;


import com.example.desafio_spring.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long productId;
    private String name;
    private Integer quantity;


    public static ProductResponse convertToResponse(Product product) {
        return new ProductResponse(product.getProductId(), product.getName(), product.getQuantity());
    }


}
