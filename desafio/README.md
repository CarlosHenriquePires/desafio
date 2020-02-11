# Desafio Guararapes
Bem vindos ao desafio guararapes, nessa fase precisamos validar seus conhecimentos em nossa Stack

### Linguagens
* Java 11
* Javascript / NodeJS ECMA 6+
* [Typescript 3+](https://www.typescriptlang.org/)

### Frameworks
* [Spring boot](https://spring.io/projects/spring-boot)
* [Angular](https://angular.io/)

### Libs 
* [Spring JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
* [Spring Batch](https://docs.spring.io/spring-batch/docs/current-SNAPSHOT/reference/html/index.html)
* [Spring Web](https://spring.io/guides/gs/serving-web-content/)
* [Spring Fox](http://springfox.github.io/springfox/docs/current/)
* [Lombok](https://projectlombok.org/)
* [Liquid Base](https://www.liquibase.org/)
* [JPA H2 Database](https://www.h2database.com/html/main.html)
* [JPA Postgres Database](https://www.postgresql.org/)

### Tools
* [Maven](https://maven.apache.org/)

## Passo 1
Observe a seguinte api [SWAPI](https://swapi.co/) e sua [documentação](https://swapi.co/documentation)

## Passo 2
Reproduza em "microservices" alguns endpoints dessa API, ou seja, usar essa estrutura para criar alguns microservices. O objetivo é poder servir dados completos sobre os personagens, ou seja, criar um microserviço para cada um dos 5 endpoints:
* films
* planets
* species
* starships
* vehicles

## Passo 3
Criar um microserviço de integração, que absorva os dados da API original e distribua entre os microservices criados

![asd](out/uml/deployment/deployment.png)

## Critérios de aceite
* Pode ser usado H2, Sqlite ou postgres
* Siga o modelo de hiperlink da api original
* Documente suas API's

## Bonus
Esses criterios não são obrigatorios porém são considerados bonus:
* Use swagger com spring fox (a documentação das apis podem ser via swagger)
* Use postgres
* Crie migrations com liquidbase
* Se fizer um front em Angular, ponto máximo