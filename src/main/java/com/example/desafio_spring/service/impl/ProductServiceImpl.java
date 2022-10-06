package com.example.desafio_spring.service.impl;

import com.example.desafio_spring.dto.ProductRequest;
import com.example.desafio_spring.exception.NotFoundException;
import com.example.desafio_spring.model.Product;
import com.example.desafio_spring.model.Purchase;
import com.example.desafio_spring.repository.ProductRepo;
import com.example.desafio_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product createProduct(Product product) {
        return productRepo.createProduct(product);
    }

    /**
     * [Descrição do que o método faz]
     *
     * @return List<Product>
     */
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
        return orderType(orderParam, products);
    }

    @Override
    public List<Product> freeShippingAndPrestigeOrdered(String prestige, String orderParam) {
        List<Product> products = filterByFreeShippingAndPrestige(prestige);
        return orderType(orderParam, products);
    }

    @Override
    public Purchase purchaseItens(List<ProductRequest> productRequestList) {
        List<Product> productList = getAllProducts();
        List<Product> productFoundList = new ArrayList<>();
        Purchase purchase = new Purchase();


        BigDecimal totalbd = new BigDecimal(0);

        for (ProductRequest productRequest : productRequestList) {

            for (Product product : productList) {

                if (product.getProductId() == productRequest.getProductId()) {
                    product.setQuantity(productRequest.getQuantity());
                    BigDecimal quantity = new BigDecimal(product.getQuantity());
                    totalbd = totalbd.add(product.getPrice().multiply(quantity));
                    productFoundList.add(product);
                }
            }
        }

        purchase.setProductList(productFoundList);
        purchase.setPurchaseId((long) (Math.random() * ((100 - 1) + 1)) + 1);
        purchase.setTotal(totalbd);


        return purchase;
    }

    private List<Product> orderType(String orderParam, List<Product> products) {
        switch (orderParam) {
            case "asc":
                return products.stream().sorted(comparing(Product::getName)).collect(Collectors.toList());
            case "desc":
                return products.stream().sorted(comparing(Product::getName).reversed()).collect(Collectors.toList());
            case "lowprice":
                return products.stream().sorted(comparing(Product::getPrice)).collect(Collectors.toList());
            case "highprice":
                return products.stream().sorted(comparing(Product::getPrice).reversed()).collect(Collectors.toList());
            default:
                throw new NotFoundException("Invalid ordering");
        }
    }


}
