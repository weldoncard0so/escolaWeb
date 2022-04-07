# EscolaWebAPI
```
 API de cadastro de alunos e professores feito com Spring MVC, mySQL, Thymeleaf.
```

# Pré-Requisitos

### Maven
### Java 18

# Executar testes automatizados

````
mvn test -P dev
````
### Empacotar dependências

````
mvn package -DskipTests
````

### Cadastrar Novo Professor
````
 localhost:8080/professores/novo
````
### Consultar todos os professores cadastrados.
````
localhost:8080/professores
````

### Consultar professor por ID
````
localhost:8080/professores/{id}

Ainda não implementado.
````

#### Deletar Professor
````
DELETE localhost:8080/professores

Ainda não implementado.
````

### Deletar todos os Professores cadastrados
````
localhost:8080/professores

Ainda não implementado.
````
