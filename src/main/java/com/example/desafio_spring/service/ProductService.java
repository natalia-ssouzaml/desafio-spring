package com.example.desafio_spring.service;

import com.example.desafio_spring.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    List<Product>filterByCategory(String category);

    List<Product>filterByCategoryAndFreeShipping(String category);
    List<Product>filterByFreeShippingAndPrestige(String prestige);
    List<Product>categoryAndFreeShippingOrdered(String category, String orderParam);

}
