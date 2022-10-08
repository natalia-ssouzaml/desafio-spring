<div align="center">
  <img src="src/main/resources/meli.png" alt="imagem meli"/>
</div>

# Desafio Spring - Grupo8

Uma plataforma de vendas de produtos online deseja melhorar as opções de pesquisa e
filtragem de seus produtos; Para isso, decidiu implementar um motor de busca que, a
partir das opções que o utilizador determina, devolve o(s) produto(s) que lhes
corresponde. Obs.: Os produtos devem ser cadastrados a partir de um payload e
armazenados em um arquivo Json. Para isto, utilizem `ObjectMapper`.

## :sparkles: Funcionalidades

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

## :busts_in_silhouette: Autores

- [@heitorsguedes](https://www.github.com/heitorsguedes)
- [@LucasVG97](https://www.github.com/LucasVG97)
- [@matkaf](https://www.github.com/matkaf)
- [@matheusbruder](https://www.github.com/matheusbruder)
- [@natalia-ssouzaml](https://www.github.com/natalia-ssouzaml)

## :books: Documentação da API

<details>
    <summary><h3>Product endpoints</h3></summary>

#### Retorna todos os produtos

```http
  GET localhost:8080/products
```

#### Retorna o produto com o id especificado

```http
  GET localhost:8080/products/id/{id}
```

#### Retorna todos os produtos da categoria

```http
  GET localhost:8080/products/{category}
```

#### Retorna os produtos com frete grátis de uma categoria

```http
  GET localhost:8080/products/freeShipping/category/{category}
```

#### Retorna os produtos por frete gratis e categoria ordenado

```http
  GET localhost:8080/products/freeShipping/category/{category}/{orderParam}
```

| **Parâmetro de Ordenação** | **Descrição**                |
|:---------------------------|:-----------------------------|
| **asc**                    | Ordem alfabética crescente   |
| **desc**                   | Ordem alfabética decrescente |
| **lowprice**               | Preço mais baixo             |
| **highprice**              | Preço mais alto              |

#### Retorna os produtos com frete grátis dada uma avaliação

```http
  GET localhost:8080/products/freeShipping/{prestige}
```

#### Retorna os produtos por frete gratis e avaliação ordenado

```http
  GET localhost:8080/products/freeShipping/prestige/{prestige}/{orderParam}
```

| **Parâmetro de Ordenação** | **Descrição**                |
|:---------------------------|:-----------------------------|
| **asc**                    | Ordem alfabética crescente   |
| **desc**                   | Ordem alfabética decrescente |
| **lowprice**               | Preço mais baixo             |
| **highprice**              | Preço mais alto              |

#### Retorna o produto que foi criado

```http
  POST localhost:8080/products
```

###### **@RequestBody**

```json
{
  "name": "Serra copo",
  "category": "Ferramentas",
  "brand": "FORTGPRO",
  "price": 2900.00,
  "quantity": 2,
  "freeShipping": false,
  "prestige": "***"
}
```

#### Retorna o pedido de compra criado com total

```http
  POST localhost:8080/products/purchase
```

###### **@RequestBody**

```json
{
  "productRequestList": [
    {
      "productId": 2,
      "quantity": 7
    },
    {
      "productId": 3,
      "quantity": 5
    }
  ],
  "customerId": 2
}
```

</details>
<details>
    <summary><h3>Customers endpoints</h3></summary>

#### Retorna todos os clientes

```http
  GET localhost:8080/customers
```

#### Retorna o cliente com o id especificado

```http
  GET localhost:8080/customers/id/{id}
```

#### Retorna todos os clientes do estado

```http
  GET localhost:8080/customers/{state}
```

#### Retorna todos os clientes com suas respectivas compras

```http
  GET localhost:8080/customers/purchases
```

#### Retorna o cliente que acabou de ser contratado

```http
  POST localhost:8080/customers
```

###### **@RequestBody**

```json
{
  "name": "Cristiano Ronaldo",
  "cpf": "38609867544",
  "city": "Belo Horizonte",
  "state": "MG",
  "email": "cr7@gmail.com",
  "password": "messiehruim"
}
```

</details>

## :file_folder: Download Endpoints

- [Collection (endpoints)](/DesafioSpring.postman_collection.json)
