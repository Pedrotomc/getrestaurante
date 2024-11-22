# Gestão de Restaurante 

## Sumário

1. [Descrição](#descrição)
2.  [Pré-requisitos](#pré-requisitos)  
3. [Instalação](#instalação)  
4. [Configuração do Banco de Dados](#configuração-do-banco-de-dados)  
5. [Execução](#execução)  
6. [Ordem de Requisições](#ordem-de-requisições)  
7. [Testes no Postman](#testes-no-postman)  
8. [Documentação](#documentação)

---

## Descrição

O Sistema de Gestão de Restaurantes é uma aplicação desenvolvida para gerenciar informações de restaurantes, incluindo pedidos, clientes, garçons, mesas e restaurantes.

---

## Pré-requisitos

- **Java 17** ou superior  
- **Maven** (para gerenciamento de dependências)  
- **PostgreSQL** (banco de dados)

---

## Instalação

### Clonar o repositório:

```bash
git clone <URL_DO_REPOSITORIO_GIT>
cd api_gestao_restaurante
```

## Intalar dependencias
```bash
mvn clean instal
```
## Endpoints da API

### Restaurante
- `POST /restaurantes` - Cadastrar restaurante
- `GET /restaurantes` - Listar restaurantes
- `PUT /restaurantes/{id}` - Atualizar restaurante
- `DELETE /restaurantes/{id}` - Deletar restaurante

### Garçom
- `POST /garcoms` - Cadastrar garçom
- `GET /garcoms` - Listar garçons
- `PUT /garcoms/{id}` - Atualizar garçom
- `DELETE /garcoms/{id}` - Deletar garçom

### Pedido
- `POST /pedidos` - Cadastrar pedido
- `GET /pedidos` - Listar pedidos
- `PUT /pedidos/{id}` - Atualizar pedido
- `DELETE /pedidos/{id}` - Deletar pedido

### Cliente
- `POST /clientes` - Cadastrar cliente
- `GET /clientes` - Listar clientes
- `PUT /clientes/{id}` - Atualizar cliente
- `DELETE /clientes/{id}` - Deletar cliente

### Mesa
- `POST /mesas` - Cadastrar mesa
- `GET /mesas` - Listar mesas
- `PUT /mesas/{id}` - Atualizar mesa
- `DELETE /mesas/{id}` - Deletar mesa

## Configuração do Banco de Dados

1. Inicie o PostgreSQL e crie o banco de dados:

   ```sql
   CREATE DATABASE api_restaurante;
   ```
---

## Execução 

Para rodar o projeto, rode o seguinte comando no terminal:

  ```sql
  mvn spring-boot:run
  ```
A aplicação esta disponivel em: `http://localhost:8080`

## Ordem das requisições

Para evitar erros de relacionamento ao usar a API, siga esta ordem para as requisições POST:

### 1. Restaurante:
Crie os restaurantes primeiro, pois os pedidos irão referenciar um restaurante.

```json
{
  "RES_NOM": "Restaurante XYZ",
  "RES_END": "Rua Principal, 123",
  "RES_TEL": "(11) 1234-5678",
  "RES_HOR": "23:59",
  "RES_EMA": "restaurante@teste.com"
}
```
### 2. Garçom:
Crie os garçons após o restaurante, associando o garçom ao restaurante
```json
{
  "GAR_NOM": "Nome do garcom",
  "GAR_IDA": "22 anos",
  "GAR_TEL": "(11) 1234-5678",
  "GAR_CPF": "999.999.999-99",
  "GAR_CAR": "Assinada",
  "GAR_END": "Rua exemplo 9999",
  "GAR_SAL": "R$ 1.300,00",
  "GAR_RES": {"id": 1}
}
```
### 3. Mesa:
Crie as mesas após os restaurantes, associando as mesas a um restaurante.
```json
{
  "MES_NUM": "123" 
}
```
### 4. Cliente:
Crie os clientes, pois eles irão fazer pedidos nos restaurantes.
```json
{
  "CLI_NOM": "nome cliente",
  "CLI_TEL": "(99) 99 99999-9999",
  "CLI_PED": "Numero do pedido"
}
```
### 5. Pedido:
Crie os pedidos, associando os pedidos ao garçom, ao cliente e ao restaurante. O pedido também deve estar vinculado a uma mesa.Crie os clientes, pois eles irão fazer pedidos nos restaurantes.
```json
{
  "hora": "2024-11-22T12:30:00",
  "detalhe": "Pedido de almoço com prato principal e suco",
  "observacao": "Sem tempero extra",
  "pratos": "Feijoada, Arroz",
  "cliente": "Maria Oliveira",
  "mesa": 12
}
```
---
## Testes no Postman

1. Importe a documentação da API no Postman usando a URL do OpenAPI (Swagger):

```text
http://localhost:8080/api-docs.json
```   
Configure a variável {{base_url}} como http://localhost:8080 para facilitar o uso dos endpoints.

---

## Documentação da API

A documentação completa da API é gerada automaticamente e pode ser acessada via Swagger. Para visualizá-la, basta acessar o seguinte link:

```text
http://localhost:8080/docs
```
Esta página fornece informações detalhadas sobre todos os endpoints disponíveis, incluindo parâmetros, métodos HTTP e exemplos de requisições e respostas.
