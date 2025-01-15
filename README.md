# DesafioForoAlura
API RESTful con Spring Boot para un foro. Autenticación JWT, JPA/Hibernate y MySQL.

# Foro API REST

API RESTful para un foro online con Spring Boot.

## Tecnologías

*   Spring Boot
*   Spring Security (JWT)
*   JPA/Hibernate
*   MySQL
*   Flyway
*   Springdoc OpenAPI

## Requisitos

*   Java 17
*   Maven (o Gradle)
*   MySQL

## Configuración

1.  Clonar: `git clone <URL_del_repositorio>`
2.  `.env`: `DB_PASSWORD`, `API_SECURITY_SECRET`
3.  Base de datos: Crear `foro_db`, `mvn flyway:migrate`
4.  Ejecutar: `mvn spring-boot:run`
