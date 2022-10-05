package com.example.desafio_spring.repository;

import com.example.desafio_spring.exception.CreationFailureException;
import com.example.desafio_spring.exception.NotFoundException;
import com.example.desafio_spring.model.Product;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public Product createProduct(Product product) {
            ObjectMapper mapper = new ObjectMapper();

            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            // Adicionar novo veículo
            List<Product> productList = getAllProducts();
            productList = new ArrayList<>(productList);
            productList.add(product);

            try {
                writer.writeValue(new File(linkFile), productList);
            } catch (Exception ex) {
                throw new CreationFailureException("Invalid creation attributes");
            }

            return product;
    }
}
