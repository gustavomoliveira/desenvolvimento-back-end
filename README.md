# Sistema de Autenticação - CLI + API REST

## 📋 Descrição
Interface de linha de comando que interage com back-end através de uma API REST em Java.

**Tecnologias:** Java, Javalin, Jackson, HttpClient

## 🏗️ Arquitetura do Projeto

```
├── backend-api/     # Servidor + API REST
└── cli-client/      # Cliente de linha de comando
```

### Backend API
- **Framework:** Javalin
- **Persistência:** CSV
- **Endpoints:** POST /cadastrar, POST /login
- **Porta:** 8080

### CLI Client  
- **Comunicação:** HttpClient
- **Parsing JSON:** Jackson
- **Interface:** Console interativo

## 🚀 Como Executar

### 1. Iniciar o Backend
```bash
cd backend-api
mvn compile exec:java -Dexec.mainClass="org.example.ServidorAPI"
```

### 2. Executar o Cliente CLI
```bash
# Em outro terminal
cd cli-client  
mvn compile exec:java -Dexec.mainClass="org.example.Main"
```

## ✨ Funcionalidades

- ✅ **Cadastro de usuários** com validações
- ✅ **Login/Autenticação** 
- ✅ **Validação de dados** (email, senha, telefone)
- ✅ **Comunicação HTTP/JSON**
- ✅ **Tratamento de erros** robusto
- ✅ **Interface amigável** no console

## 🧪 Fluxo de Teste

1. Execute o backend
2. Execute o CLI
3. Teste cadastro de novo usuário
4. Teste login com credenciais válidas
5. Teste login com credenciais inválidas

## 📝 Requisitos

- Java 11+
- Maven 3.6+
- Dependências: Javalin, Jackson

## 👤 Autor

**Gustavo Mendes de Oliveira**  
Projeto de Bloco: Desenvolvimento Back-End - 25E2_5
