package com.example.desafio_spring.controller;

import com.example.desafio_spring.model.Product;
import com.example.desafio_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(path = "/{category}")
    public ResponseEntity<List<Product>> filterByCategory(@PathVariable String category) {
        return new ResponseEntity<>(productService.filterByCategory(category), HttpStatus.OK);
    }

    @GetMapping(path = "/{category}/freeShipping")
    public ResponseEntity<List<Product>> filterByCategoryAndFreeShipping(@PathVariable String category) {
        return new ResponseEntity<>(productService.filterByCategoryAndFreeShipping(category), HttpStatus.OK);
    }

    @GetMapping(path = "/freeShipping/{prestige}")
    public ResponseEntity<List<Product>> filterByFreeShippingAndPrestige(@PathVariable String prestige) {
        return new ResponseEntity<>(productService.filterByFreeShippingAndPrestige(prestige), HttpStatus.OK);
    }
    @GetMapping(path = "/freeShipping/{category}/{orderParam}")
    public ResponseEntity<List<Product>> categoryAndFreeShippingOrdered(@PathVariable String category, @PathVariable String orderParam) {
        return new ResponseEntity<>(productService.categoryAndFreeShippingOrdered(category, orderParam), HttpStatus.OK);
    }


}
