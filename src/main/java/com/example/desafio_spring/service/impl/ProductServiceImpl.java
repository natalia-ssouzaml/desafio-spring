package com.example.desafio_spring.service.impl;

import com.example.desafio_spring.dto.ProductRequest;
import com.example.desafio_spring.exception.ExceededQuantityException;
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
import java.util.Objects;
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
        Purchase purchase = new Purchase();
        List<Product> productList = getAllProducts();
        List<Product> productFoundList = productsVerification(productRequestList, productList);
        BigDecimal total = new BigDecimal(0);

        for (Product product : productFoundList) {
            BigDecimal quantity = new BigDecimal(product.getQuantity());
            total = total.add(product.getPrice().multiply(quantity));
        }

        purchase.setPurchaseId((long) (Math.random() * ((100 - 1) + 1)) + 1);
        purchase.setProductList(productFoundList);
        purchase.setTotal(total);
        return purchase;
    }

    private List<Product> productsVerification(List<ProductRequest> productRequestList, List<Product> products) {
        List<Product> productFoundList = new ArrayList<>();

        for (ProductRequest productRequest : productRequestList) {
            boolean productFound = false;
            for (Product product : products) {
                if (Objects.equals(product.getProductId(), productRequest.getProductId())) {
                    if (productRequest.getQuantity() > product.getQuantity()) {
                        throw new ExceededQuantityException("Quantity of products exceeded");
                    }
                    product.setQuantity(productRequest.getQuantity());
                    productFoundList.add(product);
                    productFound = true;
                }
            }
            if (!productFound) {
                throw new NotFoundException("ProductId not found: Id[" + productRequest.getProductId() + "]");
            }
        }
        return productFoundList;
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
