# Java Spring Boot

## Install Java Development Kit (JDK)
- https://bell-sw.com/pages/downloads/#/java-17-lts

## Spring boot Initializr
- https://start.spring.io/

## Download Eclipse IDE
https://www.eclipse.org/downloads/packages/
### Eclipse IDE for Enterprise Java and Web Developers
- https://www.eclipse.org/downloads/packages/release/2023-03/r/eclipse-ide-enterprise-java-and-web-developers

## Spring Boot in Visual Studio Code
- https://code.visualstudio.com/docs/java/java-spring-boot

## Dependencies
- Spring Boot DevTools
- Spring Web
- Lombok
- Gson
- Spring Data JPA
- MySQL Driver

## Docker image
``` bash
docker pull eclipse-temurin:17-jdk-alpine
docker pull amazoncorretto:17.0.7-alpine
```

## Start server and application
``` bash
docker compose up -d --build
```

## Test

### Add Product
``` bash
curl --location --request POST 'http://localhost:5000/v1/product' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "product1",
    "quantity": 10,
    "price": 2000
}'
```

### Add Products
``` bash
curl --location --request POST 'http://localhost:5000/v1/product/list' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "name": "product2",
        "quantity": 20,
        "price": 5000
    },
    {
        "name": "product3",
        "quantity": 30,
        "price": 10000
    }
]'
```

### Get Products
``` bash
curl --location --request GET 'http://localhost:5000/v1/product/all'
```

### Get Product By ID
``` bash
curl --location --request GET 'http://localhost:5000/v1/product/1'
```

### Get Product By Name
``` bash
curl --location --request GET 'http://localhost:5000/v1/product/name/product1'
```

### Update Product
``` bash
curl --location --request PUT 'http://localhost:5000/v1/product' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id":3,
    "name": "productB",
    "quantity": 200,
    "price": 20000
}'
```

### Delete Product
``` bash
curl --location --request DELETE 'http://localhost:5000/v1/product/2'
```

### Get Accounts
``` bash
curl --location --request GET 'http://localhost:5000/v1/account'
```

### Add Account
``` bash
curl --location --request POST 'http://localhost:5000/v1/account' \
--header 'Content-Type: application/json' \
--data-raw '{
    "accountNo": "123-4567-890",
    "name": "name-test",
    "description": "desc-test"
}'
```

## Software stack
- Java Spring Boot
- Node.js
- MySQL