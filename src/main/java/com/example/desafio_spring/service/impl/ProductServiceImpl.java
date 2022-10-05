package com.example.desafio_spring.service.impl;

import com.example.desafio_spring.exception.NotFoundException;
import com.example.desafio_spring.model.Product;
import com.example.desafio_spring.repository.ProductRepo;
import com.example.desafio_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

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
        List<Product> products = getAllProducts().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());

        if (products.isEmpty()) {
            throw new NotFoundException("There are not any products in this category: " + category);
        }

        return products;
    }

    @Override
    public List<Product> filterByCategoryAndFreeShipping(String category) {

        List<Product> products = getAllProducts().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getFreeShipping())
                .collect(Collectors.toList());

        if (products.isEmpty()) {
            throw new NotFoundException("There are not any products with free shipping in this category: " + category);
        }

        return products;
    }

    @Override
    public List<Product> filterByFreeShippingAndPrestige(String prestige) {
        List<Product> products = getAllProducts().stream()
                .filter(p -> p.getPrestige().equals(prestige) && p.getFreeShipping())
                .collect(Collectors.toList());

        if (products.isEmpty()) {
            throw new NotFoundException("There are not any products with free shipping in this rating");
        }

        return products;
    }

    @Override
    public List<Product> categoryAndFreeShippingOrdered(String category, String orderParam) {
        List<Product> products = filterByCategoryAndFreeShipping(category);

        switch (orderParam) {
            case "asc":
                return products.stream().sorted(comparing(Product::getName)).collect(Collectors.toList());
            case "desc":
                return products.stream().sorted(comparing(Product::getName).reversed()).collect(Collectors.toList());
            case "lowprice":
                return products.stream().sorted(comparing(Product::getPrice)).collect(Collectors.toList());
            case "highprice":
                return products.stream().sorted(comparing(Product::getPrice).reversed()).collect(Collectors.toList());
            default: throw new NotFoundException("Invalid ordering");
        }

    }

}
