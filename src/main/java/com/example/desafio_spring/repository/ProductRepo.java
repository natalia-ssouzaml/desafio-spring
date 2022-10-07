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
import java.util.Optional;

@Repository
public class ProductRepo {

    private final String linkFile = "src/main/resources/products.json";

    /**
     * Método responsável por retornar uma lista com todos os produtos
     *
     * @return List<Product>
     */

    public Optional<Product> getProductById(Long id) {
        return getAllProducts().stream()
                .filter(p -> p.getProductId() == id)
                .findFirst();
    }

    public List<Product> getAllProducts() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList(mapper.readValue(new File(linkFile), Product[].class));
        } catch (Exception e) {
            throw new NotFoundException("Empty product list");
        }
    }

    /**
     * Método responsável por salvar um novo produto
     *
     * @param product -> novo produto adicionado
     * @return Product -> novo produto criado
     */
    public Product createProduct(Product product) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<Product> productList = getAllProducts();
        productList = new ArrayList<>(productList);
        product.setProductId((long) productList.get(productList.size() - 1).getProductId() + 1);
        productList.add(product);

        try {
            writer.writeValue(new File(linkFile), productList);
        } catch (Exception ex) {
            throw new CreationFailureException("Invalid creation attributes");
        }

        return product;
    }
}
