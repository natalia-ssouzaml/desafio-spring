package com.example.desafio_spring.repository;

import com.example.desafio_spring.exception.NotFoundException;
import com.example.desafio_spring.exception.ReadingFailException;
import com.example.desafio_spring.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepo {

    private String linkFile = "src/main/resources/products.json";

    public List<Product> getAllProducts() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList(mapper.readValue(new File(linkFile), Product[].class));
        } catch (Exception e) {
            throw new NotFoundException("Empty product list");
        }
    }
}
