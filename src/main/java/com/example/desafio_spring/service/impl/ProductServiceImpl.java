package com.example.desafio_spring.service.impl;

import com.example.desafio_spring.exception.NotFoundException;
import com.example.desafio_spring.model.Product;
import com.example.desafio_spring.repository.ProductRepo;
import com.example.desafio_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.getAllProducts();
    }


    //3. Retornar uma lista de produtos filtrados por categoria.
    @Override
    public List<Product> filterByCategory(String category) {
        List<Product> products = getAllProducts();
        List<Product> optionalProducts = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());

        if (optionalProducts.isEmpty()) {
            throw new NotFoundException("There are any products in this category: " + category);
        }

        return optionalProducts;
    }
}
