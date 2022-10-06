package com.example.desafio_spring.controller;

import com.example.desafio_spring.dto.ProductRequest;
import com.example.desafio_spring.model.Product;
import com.example.desafio_spring.model.Purchase;
import com.example.desafio_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(path = "/freeShipping/{category}")
    public ResponseEntity<List<Product>> filterByCategoryAndFreeShipping(@PathVariable String category) {
        return new ResponseEntity<>(productService.filterByCategoryAndFreeShipping(category), HttpStatus.OK);
    }

    @GetMapping(path = "/freeShipping/{prestige}")
    public ResponseEntity<List<Product>> filterByFreeShippingAndPrestige(@PathVariable String prestige) {
        return new ResponseEntity<>(productService.filterByFreeShippingAndPrestige(prestige), HttpStatus.OK);
    }

    @GetMapping(path = "/freeShipping/category/{category}/{orderParam}")
    public ResponseEntity<List<Product>> categoryAndFreeShippingOrdered(@PathVariable String category, @PathVariable String orderParam) {
        return new ResponseEntity<>(productService.categoryAndFreeShippingOrdered(category, orderParam), HttpStatus.OK);
    }

    @GetMapping(path = "/freeShipping/prestige/{prestige}/{orderParam}")
    public ResponseEntity<List<Product>> freeShippingAndPrestigeOrdered(@PathVariable String prestige, @PathVariable String orderParam) {
        return new ResponseEntity<>(productService.freeShippingAndPrestigeOrdered(prestige, orderParam), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PostMapping(path = "/purchase")
    public ResponseEntity<Purchase>sendPurchase(@RequestBody List<ProductRequest> list){

        return new ResponseEntity<>(productService.purchaseItens(list),HttpStatus.CREATED);
    }
}
