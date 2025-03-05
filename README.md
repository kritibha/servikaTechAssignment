# servikaTechAssignment
# Microservices Project

## Project Overview
This project demonstrates a simple microservices-based system using Java, Spring Boot. The system consists of three microservices: User Service, Order Service, and Product Service. Each service manages different aspects of the application and communicates with each other using REST APIs.

## Project Structure
- **user-service**: Manages user accounts (CRUD operations) using an in-memory H2 database.
- **order-service**: Handles orders placed by users (CRUD operations) using a MySQL database.
- **product-service**: Manages product listings (CRUD operations) using a MongoDB database.

## Prerequisites
- Java 17
- Maven

## Setup Instructions

### 1. Clone the Repository
```sh
git clone https://github.com/your-username/microservices-project.git
cd microservices-project

#Build the projects
mvn clean install

#Access the Services
#User Service: 
http://localhost:8081
#Order Service: 
http://localhost:8082
#Product Service: 
http://localhost:8083

#API Endpoints
#User Service
Create User: POST /users/new
{
  "name": "John",
  "email": "john@test.com"
}
Get User: GET /users/{id} or GET /users/all
Update User: PUT /users/{id}
{
  "name": "John Doe",
  "email": "john.doe@test.com"
}
Delete User: DELETE /users/{id}

#Order Service
Create Order: POST /orders/{userId}
{
  "productCode": "Nokia",
  "price": 1500,
  "quantity": 2
}

#Product Service
Create Product: POST /products/new
{
  "name": "Samsung",
    "description": "Sansung android phone",
    "price": 15000
}
Get Product: GET /products/all

#API Documentation
#Access the API documentation using Swagger UI:
#User Service: 
http://localhost:8081/swagger-ui.html
#Order Service: 
http://localhost:8082/swagger-ui.html
#Product Service: 
http://localhost:8083/swagger-ui.html

#Health Checks
#Access the health endpoints to monitor the status of each service:
#User Service: 
http://localhost:8081/actuator/health
#Order Service: 
http://localhost:8082/actuator/health
#Product Service: 
http://localhost:8083/actuator/health
