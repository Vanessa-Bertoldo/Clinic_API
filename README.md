<p align="center">
  <a href="https://spring.io/projects/spring-boot" target="blank"><img src="/assets/springboot.png" width="320" alt="Spring boot Logo" /></a>
</p>

# API Rest with Java and Spring Boot
<p>This API is based on a system for internal use of a medical clinic</p>

## Prerequisites ⚒️
<ul>
    <li>Mysql</li>
    <li>JDK (version 17)</li>
</ul>

## Technologies 💻
<ul>
    <li>Spring Boot 3</li>
    <li>Java 17</li>
    <li>Lombok </li>
    <li>MySQL / Flyway</li>
    <li>JPA / Hibernate</li>
    <li>Maven</li>
</ul>

## How the API works
### Database creation
```bash
    $ create database vollmed_api;
```
<p>Configure the file "application.properties" with data from your database </p>

```bash
    spring:
        datasource:
            driver-class-name: com.mysql.cj.jdbc.Driver
            url: jdbc:mysql://localhost:3306/clinica
            username: username
            password: password
```  
<p>When running the application, the migrations will be executed in the database</p>
<p align="center">
  <a href="https://spring.io/projects/spring-boot" target="blank"><img src="/assets/migrations.jpeg" width="320" alt="Spring boot Logo" /></a>
</p>


### Tests

<p>Recommendations:</p>
<ul>
    <li>Postman</li>
    <li>insomnia</li>
</ul>
