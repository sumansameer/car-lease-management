# Car Lease Management API

A Spring Boot application for managing customer information, car details, and lease calculations. Implements user authentication and includes Swagger documentation.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
  - [Endpoints](#endpoints)
- [Swagger Documentation](#swagger-documentation)
- [Contributing](#contributing)

## Features

1. **Manage Customer Information:**
   - View, add, modify, and delete basic customer information.

2. **Manage Car Details:**
   - Maintain essential car attributes.

3. **Calculate Lease Rate:**
   - Automatically calculate the lease rate based on mileage, duration, interest rate, and net price.

4. **User Authentication:**
   - Securely log into the API to access and manage customer and car data.



## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database (in-memory)
- JWT (JSON Web Tokens) for Authentication
- Swagger for API Documentation

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven (for building the project)

### Installation

1. Clone the repository:

   ```bash
     git clone https://github.com/sumansameer/car-lease-management.git

2. Build the project:

      bash
      cd car-lease-management
      mvn clean install
3. Run the application:

   bash
   mvn spring-boot:run

   or
  
   java -jar target/carlease-0.0.1-SNAPSHOT.jar --server-port=8080  

4. Configuration
    Configure the application by modifying the application.properties or application.yml file as needed.

Usage
Endpoints
Manage Customer Information:

GET /api/customers: Get all customers.
GET /api/customers/{id}: Get customer by ID.
POST /api/customers: Add a new customer.
PUT /api/customers/{id}: Update customer by ID.
DELETE /api/customers/{id}: Delete customer by ID.
Manage Car Details:

GET /api/cars: Get all cars.
GET /api/cars/{id}: Get car by ID.
POST /api/cars: Add a new car.
PUT /api/cars/{id}: Update car by ID.
DELETE /api/cars/{id}: Delete car by ID.
Calculate Lease Rate:

POST /api/leases/calculate: Calculate lease rate.
User Authentication:

POST /api/auth/login: User login.
Security for API Calls:

JWT token is required for secure API calls.
Authentication
To access secured endpoints, obtain a JWT token by making a login request to /api/auth/login. Include the token in the Authorization header for subsequent API calls(not completely implemented).

Swagger Documentation
Access the Swagger API documentation at http://localhost:8080/swagger-ui.html after starting the application.

Contributing
Feel free to contribute by opening issues, providing feedback, or submitting pull requests.

