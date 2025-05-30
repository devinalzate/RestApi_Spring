# Taller_1_SpringACM

# Integrantes

### Devin Alzate - 20231020214
### Santiago Chavarro - 20231020219
### Santiago Rodriguez Reyes - 20231020089


## Project Overview

This Spring Boot application is an e-commerce platform that integrates with FakeStoreAPI to provide product catalog, shopping cart, and user management functionalities.

## Technical Stack

- **Java 11+**
- **Spring Boot**
- **Maven**
- **RestTemplate** for API communication

## Architecture

The project follows a layered architecture:

- **Controllers**: Handle HTTP requests and responses
- **Services**: Implement business logic and API integration
- **DTOs**: Transfer data between layers
- **Persistence**: Entity models and repositories

## Key Components

### Services

- **ProductServiceImpl**: Manages product catalog operations
- **CartServiceImpl**: Handles shopping cart functionality
- **UserServiceImpl**: Manages user accounts
- **AuthServiceImpl**: Handles authentication

### Data Transfer Objects (DTOs)

- **ProductDTO**: Product information
- **CartDTO**: Shopping cart details
- **UsersDTO**: User account data
- **ProductCartDTO**: Products within a cart
- **AuthRequest/AuthResponse**: Authentication data

## API Integration

The application consumes an external REST API (FakeStoreAPI) for all data operations, functioning as a backend-for-frontend layer with additional business logic and transformations.

## Features

- Product catalog browsing
- Shopping cart management
- User authentication
- User profile management

## How to Run

1. Clone the repository
2. Run `mvn clean install`
3. Start the application with `mvn spring-boot:run`
4. Access the API at `http://localhost:8080`

## Available Endpoints

- **Products**: `/api/v1/products`
- **Carts**: `/api/v1/cart`
- **Users**: `/api/v1/user`
- **Authentication**: `/api/v1/auth`
