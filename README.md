![Logo](src/main/resources/meli.png)

# Desafio Spring - Grupo8

Uma plataforma de vendas de produtos online deseja melhorar as opções de pesquisa e
filtragem de seus produtos; Para isso, decidiu implementar um motor de busca que, a
partir das opções que o utilizador determina, devolve o(s) produto(s) que lhes
corresponde. Obs: Os produtos devem ser cadastrados a partir de um payload e
armazenados em um arquivo Json. Para isto, utilizem ObjectMapper.

## Funcionalidades

1. Cadastrar uma lista de produtos.
2. Retornar uma lista de todos os produtos disponíveis
3. Retornar uma lista de produtos filtrados por categoria.
4. Retornar uma lista que permite as seguintes combinações de filtros:
    - categoria + frete grátis.
    - frete grátis + avaliação (*)

Por outro lado, uma vez que se pretende uma boa experiência do usuário no que diz
respeito à forma de apresentação dos produtos, é necessário que os resultados
fornecidos pela API possam ser ordenados por qualquer um dos seguintes critérios

5. Alfabético (crescente e decrescente)
6. Preço mais alto
7. Preço mais baixo

Ao mesmo tempo, é necessária uma API que forneça:

8. Possibilidade de envio de pedido de compra. A partir disso, o preço total da
   requisição feita pode ser recebido como resposta.
    - Leve em consideração, para cada uma dessas solicitações, os possíveis
      "status code" que podem ser retornados.
    - Por exemplo:
        - Se um produto que não existe for solicitado, retorne o código de
          status correspondente.
        - Se houver um problema com o servidor e a conexão não puder ser
          feita, o código de status correspondente deve ser retornado.

## Autores

- [@heitorsguedes](https://www.github.com/heitorsguedes)
- [@LucasVG97](https://www.github.com/LucasVG97)
- [@matkat](https://www.github.com/matkaf)
- [@matheusbruder](https://www.github.com/matheusbruder)
- [@natalia-ssouzaml](https://www.github.com/natalia-ssouzaml)

## Documentação da API

#### Retorna todos os produtos

```http
  GET localhost:8080/products
```

#### Retorna todos os produtos da categoria

```http
  GET localhost:8080/products/{category}
```

#### Retorna os produtos com frete grátis de uma categoria

```http
  GET localhost:8080/products/freeShipping/category/{category}
```

#### Retorna os produtos com frete grátis dada uma avaliação

```http
  GET localhost:8080/products/freeShipping/{prestige}
```

#### Retorna os produtos por frete gratis e categoria ordenado

```http
  GET localhost:8080/products/freeShipping/category/{category}/{orderParam}
```

#### Retorna os produtos por frete gratis e avaliação ordenado

```http
  GET localhost:8080/products/freeShipping/prestige/{prestige}/{orderParam}
```

#### Retorna o produto que foi criado

```http
  POST localhost:8080/products

    @RequestBody
    {
        "name": "Serra de fita",
        "category": "Ferramentas",
        "brand": "FORTGPRO",
        "price": 2900.00,
        "quantity": 3,
        "freeShipping": false,
        "prestige": "***"
    }
```

#### Retorna o pedido de compra criado

```http
  POST localhost:8080/products/purchase

    @RequestBody
    [
        {
            "productId": 2,
            "name": "Furadeira",
            "quantity": 7
        },
        {
            "productId": 1,
            "name": "Serra de Bancada",
            "quantity": 5
        }
    ]
```

### Arquivo documentação 

- [Collection (endpoints)](endpoints-collection.har)
