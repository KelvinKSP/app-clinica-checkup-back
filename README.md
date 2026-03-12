# 🏥 Checkup API

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-25.0.2-orange)
![Maven](https://img.shields.io/badge/Maven-3.9.13-blue)
![Spring](https://img.shields.io/badge/Spring-4.0.3-green)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

Backend da aplicação mobile da **Clínica Checkup**.

Este projeto fornece a API responsável por gerenciar os dados e funcionalidades utilizadas pelo aplicativo mobile da clínica, incluindo autenticação, gerenciamento de usuários, dados clínicos e demais recursos necessários para o funcionamento da plataforma.

⚠️ **O projeto ainda está em fase inicial de desenvolvimento.**

---

# 🚀 Tecnologias utilizadas

- **Java 25.0.2**
- **Apache Maven 3.9.13**
- **Spring Framework 4.0.3**
- **PostgreSQL**

---

# 📦 Dependências principais

O projeto utiliza algumas dependências iniciais do ecossistema Spring para acelerar o desenvolvimento da API:

- **Spring Web**
- **Spring Data JPA**
- **Spring Security**
- **Spring Validation**
- **Lombok**
- **PostgreSQL Driver**
- **Spring Boot DevTools**
- **Swagger / OpenAPI (documentação da API)**

Essas dependências permitem:

- criação de APIs REST
- acesso e persistência de dados
- autenticação e segurança
- validação de dados
- documentação automática da API

---

# 📚 Documentação da API

A documentação da API será disponibilizada através do **Swagger UI**.

Após iniciar a aplicação, a documentação poderá ser acessada em:
http://localhost:8080/swagger-ui/index.html


---

# ⚙️ Configuração do ambiente

## 1️⃣ Clonar o repositório 

```bash
git clone https://github.com/KelvinKSP/app-clinica-checkup-back.git
```

## 2️⃣ Entrar na pasta do projeto

```bash
cd app-clinica-checkup-back
```

## 3️⃣ Compilar o projeto
```bash
mvn clean install
```

## 4️⃣ Rodar a aplicação
```bash
mvn spring-boot:run
```

