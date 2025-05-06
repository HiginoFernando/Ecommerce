```markdown
# 🛒 E-Commerce API - Java Spring Boot

Projeto de uma API RESTful para um sistema de e-commerce desenvolvido em **Java com Spring Boot**. A aplicação permite o gerenciamento de **usuários, produtos, categorias, pedidos, pagamentos e itens do pedido**.

---

## 📁 Estrutura do Projeto

```

com.revisao.ecommerce
├── controllers       → Camada responsável pelas rotas HTTP (REST API)
├── dto               → Objetos de transferência de dados entre cliente e servidor
└── entities          → Entidades JPA (modelo de dados)

````

### 📦 Pacotes e Classes

#### `controllers`
- `CategoriaController.java`
- `ItemDoPedidoController.java`
- `PagamentoController.java`
- `PedidoController.java`
- `ProdutoController.java`
- `UsuarioController.java`

#### `dto`
- `CategoriaDTO.java`
- `ItemDoPedidoDTO.java`
- `PagamentoDTO.java`
- `PedidoDTO.java`
- `ProdutoDTO.java`
- `UsuarioDTO.java`

#### `entities`
- `Categoria.java`
- `ItemDoPedido.java`
- `ItemDoPedidoPK.java`
- `Pagamento.java`
- `Pedido.java`
- `Produto.java`
- `StatusDoPedido.java`
- `Usuario.java`

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database (ou outro banco relacional)
- Maven
- Postman (para testes)

---

## 🔗 Principais Endpoints

### 📦 Produtos
- `GET /produtos`  
- `POST /produtos`
- `PUT /produtos/{id}`
- `DELETE /produtos/{id}`

### 📁 Categorias
- `GET /categorias`  
- `POST /categorias`

### 🛍️ Pedidos
- `GET /pedidos`  
- `POST /pedidos`  
- `PUT /pedidos/{id}`  
- `DELETE /pedidos/{id}`

### 👤 Usuários
- `GET /usuarios`  
- `POST /usuarios`

---

## 📌 Exemplo de JSON para Criar Pedido

```json
{
  "momento": "2025-05-06T12:00:00",
  "usuario": {
    "id": 1
  },
  "pagamento": {
    "status": "PAGO"
  },
  "itens": [
    {
      "produtoId": 1,
      "quantidade": 2,
      "preco": 99.90
    }
  ]
}
````

---

## ▶️ Como Rodar o Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/HiginoFernando/Ecommerce.git
   cd ecommerce-java
   ```

2. Compile e rode com o Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

3. Acesse a aplicação:

   ```
   http://localhost:8080
   ```

---

## 🧪 Testando com Postman

Você pode usar o Postman para testar todos os endpoints. Lembre-se de enviar os dados no formato `application/json` no corpo da requisição quando necessário.

---

## 📃 Licença

Este projeto está sob a licença MIT.

