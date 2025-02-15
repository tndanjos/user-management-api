# Tech Challenge da Fase 1 Pós FIAP 7ADJT

## Restaurant Management API

### Arquitetura da Aplicação 

```
src/main/java/fiap/techchallenge/restaurant-management-api/
├── entity/              # Classes representando tabelas do db
├── dto/                 # Objetos de Transferência de Dados (DTO)
│   ├── request/         # DTOs para dados de entrada (requests)
│   └── response/        # DTOs para dados de saída (responses)
├── enums/               # Definições de tipos enumerados
├── controller/          # Endpoints REST
├── service/             # Lógica de negócios
├── repository/          # Interfaces JPA para persistência
├── config/              # Configurações do projeto
├── exception/           # Classes para tratamento de exceções
```

```mermaid
graph TD
    A[restaurant-management-api] --> B[entity]
    A --> C[dto]
    C --> D[request]
    C --> E[response]
    A --> F[enums]
    A --> G[controller]
    A --> H[service]
    A --> I[repository]
    A --> J[config]
    A --> K[exception]

    B:::package
    C:::package
    D:::subPackage
    E:::subPackage
    F:::package
    G:::package
    H:::package
    I:::package
    J:::package
    K:::package

classDef package fill:#4169E1,stroke:#000,stroke-width:1px;
classDef subPackage fill:#6495ED,stroke:#000,stroke-width:1px;
```

### Rodando a aplicação

#### Rodando o Docker para construção dos containers
```bash
docker-compose build
````

#### Rodando a aplicação com docker
```bash
$ docker-compose up
```

#### Rodando em paralelo
```bash
$ docker-compose up -d
```

#### Acessando o container
```bash
$ docker exec -it restaurant-management-api sh
```

### Usando Postman

É possível importar uma collection do Postman usando o arquivo `RestaurantManagementApi-7ADJT.postman_collection.json`
que está na raiz do projeto.

O processo de autenticação funciona por meio de um `Basic Auth`.

- Navegue no Postman até a aba `Authorization;
- Selecione o tipo `Basic Auth`;
- E passe o username e password;
- Você pode usar Environment Variables para facilitar a troca de credenciais;

#### Endpoints


| **Endpoint**           | **Método** | **Descrição**                                                                      | Precisa de Autorização | **Exemplo de Requisição**                                                                                                                                                              |
| ---------------------- | ---------- | ---------------------------------------------------------------------------------- | ---------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `/users`               | POST       | Cria um novo usuário no sistema.                                                   | Não                    | **URL**: `http://localhost:8080/users`  <br> **Body**: `{ "name": "John Doe", "email": "john.doe@example.com", "type": "CUSTOMER", "username": "johndoe", "password": "password123" }` |
| `/users/{id}`          | GET        | Obtém os detalhes de um usuário pelo ID.                                           | Sim                    | **URL**: `http://localhost:8080/users/1`                                                                                                                                               |
| `/users`               | GET        | Lista todos os usuários com suporte a paginação.                                   | Sim                    | **URL**: `http://localhost:8080/users?page=0&size=10`                                                                                                                                  |
| `/users/{id}`          | PUT        | Atualiza os dados de um usuário existente.                                         | Sim                    | **URL**: `http://localhost:8080/users/1`  <br> **Body**: `{ "name": "John Updated", "email": "john.updated@example.com", "type": "OWNER", "username": "johnupdated" }`                 |
| `/users/{id}`          | DELETE     | Remove um usuário pelo ID.                                                         | Sim                    | **URL**: `http://localhost:8080/users/1`                                                                                                                                               |
| `/users/{id}/password` | PATCH      | Atualiza a senha de um usuário existente.                                          | Sim                    | **URL**: `http://localhost:8080/users/1/password`  <br> **Body**: `{ "oldPassword": "oldpassword123", "newPassword": "newpassword456" }`                                               |
| `/api/auth/login`      | POST       | Realiza o login de um usuário no sistema, retornando dados de autenticação.        | Não                    | **URL**: `http://localhost:8080/api/auth/login`  <br> **Body**: `{ "username": "johndoe", "password": "password123" }`                                                                 |
| `/health`              | GET        | Verifica a saúde da aplicação, retornando uma mensagem de status de funcionamento. | Não                    | **URL**: `http://localhost:8080/health`                                                                                                                                                |



