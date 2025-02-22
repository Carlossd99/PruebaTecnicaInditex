# Prueba Técnica - Inditex

## Descripción del Proyecto

Este proyecto es una API REST desarrollada en **Spring Boot 3.4.3**, que permite obtener la información de precios de productos según la fecha y marca solicitada. Implementa una arquitectura **MVC**, con **caché**, manejo de excepciones y pruebas automatizadas.

---

## Arquitectura y Tecnologías Utilizadas

| Tecnología                            | Descripción                                  |
|---------------------------------------| -------------------------------------------- |
| **Java 23**                           | Lenguaje de programación principal           |
| **Spring Boot 3.4.3**                 | Framework para el desarrollo de la API       |
| **Maven**                             | Gestor de dependencias y build               |
| **Spring Web**                        | Para la creación de servicios REST           |
| **Spring Data JPA**                   | Para la interacción con la base de datos     |
| **H2 Database**                       | Base de datos en memoria para pruebas        |
| **Caffeine Cache**                    | Implementación de caché para optimización    |
| **Swagger (Springdoc OpenAPI 2.2.0)** | Documentación de la API                      |
| **JUnit 5 & Mockito**                 | Pruebas unitarias e integración              |


Por defecto, la API estará disponible en `http://localhost:8080`.


## 📂 Estructura del Código

```
pruebatecnica/
│── src/main/java/com/inditex/pruebatecnica/
│   ├── controller/         # Controladores REST
│   ├── service/            # Lógica de negocio
│   ├── repository/         # Acceso a datos con JPA
│   ├── model/              # Entidades y DTOs
│   ├── exceptions/         # Manejo de errores
│   ├── config/             # Configuraciones de caché, seguridad, etc.
│── src/test/java/com/inditex/pruebatecnica/  # Pruebas unitarias e integración
│── pom.xml                 # Archivo de dependencias Maven
```

---

## API Endpoints

### **Obtener precio según fecha y marca**

```http
POST /prices/productData
```

**Request Body (JSON):**

```json
{
  "productId": 35455,
  "brandId": 1,
  "date": "2020-06-14T10:00:00"
}
```
**Response (JSON):**

```json
{
  "brandId": 1,
  "startDate": "2020-06-14T00:00:00",
  "endDate": "2020-06-14T23:59:59",
  "priceList": 1,
  "productId": 35455,
  "priority": 1,
  "price": 35.50,
  "curr": "EUR"
}
```

**Ver documentación completa en:** [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

---

## Manejo de Excepciones

La API implementa un **manejador global de excepciones** utilizando `@ControllerAdvice`.

### **Ejemplo: Producto no encontrado**

**Código de estado:** `404 Not Found`

```json
{
  "timestamp": "2025-02-22T13:04:33.3902",
  "status": 404,
  "error": "Price Not Found",
  "message": "No hay datos disponibles para mostrar"
}
```

---

## Caché

📌 **Configuración en ****`application.properties`****:**

```properties
# Cache
spring.cache.type=caffeine
```

---

## Pruebas Unitarias e Integración

**Ejecutar pruebas:**

```bash
mvn test
```

**Cobertura de pruebas:**

Pruebas unitarias con `Mockito` y `JUnit 5`

Pruebas de integración con `Spring Boot Test`

Validación de respuestas en Swagger

100% de cobertura del código

---


