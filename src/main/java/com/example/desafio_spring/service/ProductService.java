package com.example.desafio_spring.service;

import com.example.desafio_spring.dto.ProductRequest;
import com.example.desafio_spring.exception.NotFoundException;
import com.example.desafio_spring.model.Product;
import com.example.desafio_spring.model.Purchase;

import java.util.List;

public interface ProductService {

    /**
     * Método responsavel por retornar produto pelo id.
     *
     * @param id > gerado automaticamente na criação de um produto.
     * @return um produto.
     **/
    Product getProductById(Long id);

    /**
     * Metodo responsavel por criar um novo produto.
     *
     * @param product > novo produto recebido atraves do body.
     * @return o produto criado.
     **/
    Product createProduct(Product product);

    /**
     * Método responsável por retornar uma lista de todos os produtos
     *
     * @return Lista de todos os produtos
     */
    List<Product> getAllProducts();

    /**
     * Método responsável por retornar uma lista de produtos de determinada categoria passada por parâmetro
     *
     * @param category — categoria do produto
     * @return List<Product> filtrado por categoria
     */
    List<Product> filterByCategory(String category);

    /**
     * Método responsável por retornar uma lista de produtos de determinada categoria passada por parâmetro com frete gratis
     *
     * @param category — categoria do produto
     * @return List<Product> filtrado por categoria com frete gratis
     * @throws NotFoundException quando uma categoria for inexistente
     */
    List<Product> filterByCategoryAndFreeShipping(String category);

    /**
     * Método responsável por retornar uma lista de produtos conforme a avaliação e com frete gratis
     *
     * @param prestige — avaliação do produto
     * @return List<Product> filtrado por avaliação e com frete gratis
     * @throws NotFoundException quando nao existir produto com a avaliação passada por parâmetro
     */
    List<Product> filterByFreeShippingAndPrestige(String prestige);

    /**
     * Método responsável por retornar uma lista de produtos conforme a categoria e com frete gratis ordenado
     * conforme a ordem escolhida
     *
     * @param category   - categoria do produto
     * @param orderParam - pode ser asc, desc, lowprice e highprice
     * @return List<Product> filtrado por categoria e com frete gratis ordenado
     */
    List<Product> categoryAndFreeShippingOrdered(String category, String orderParam);

    /**
     * Método responsável por retornar uma lista de produtos conforme a avaliação e com frete gratis ordenado
     * conforme a ordem escolhida
     *
     * @param prestige   — avaliação do produto
     * @param orderParam -> pode ser asc, desc, lowprice e highprice
     * @return List<Product> filtrado por avaliação e com frete gratis ordenado
     */
    List<Product> freeShippingAndPrestigeOrdered(String prestige, String orderParam);

    /**
     * Método responsável por registrar a compra de um ou mais produtos
     *
     * @param productRequestList -> lista de produtos solicitados
     * @return List<Product> -> uma lista com os produtos solicitados
     */
    Purchase purchaseItens(List<ProductRequest> productRequestList);
}
