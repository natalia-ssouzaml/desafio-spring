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

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        Optional<List<Product>> products = productRepo.getAllProducts();
        if(products.isEmpty()){
            throw new NotFoundException("Product not found");
        }
        return products.get();
    }
}
