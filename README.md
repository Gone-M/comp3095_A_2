# Event Management System

This project implements a microservices-based event management system with key features including secure API communication, enhanced inter-service messaging, resilience patterns, and comprehensive API documentation.

## Features Implemented

### Part 1: Secure API Gateway
- **Spring Cloud Gateway** is configured as the centralized entry point for all microservices.
- Integrated **Keycloak** for authentication and role-based access control:
  - **BookingService** and **ApprovalService** are secured, requiring authentication for access.
  - Role-based access is enforced:
    - Only **staff members** can access the **ApprovalService**.
- Keycloak configuration ensures robust security across microservices.

### Part 2: Enhanced Inter-Service Communication with Kafka and Schema Registry
- **Apache Kafka** is used for asynchronous communication between microservices:
  - **BookingService** publishes booking events to Kafka when a booking is confirmed.
  - **EventService** consumes these events to register new events for confirmed bookings.
- **Schema Registry** is integrated to manage and validate Kafka message schemas:
  - Ensures schema compatibility to prevent breaking changes.
  - Strict validation of message structures using Avro schema.

### Part 3: Circuit Breaker Pattern with Resilience4J
- Implemented **Resilience4J** Circuit Breakers to ensure resilience:
  - **BookingService** uses Circuit Breaker for RoomService calls to handle potential failures during room availability checks.
  - **ApprovalService** uses Circuit Breaker for UserService calls to fetch user roles, providing fallback responses during downtime.
- Fallback mechanisms are implemented to prevent cascading failures and maintain system stability.

### Part 4: API Documentation with Swagger
- **Swagger** is integrated into each microservice for comprehensive API documentation.
- API Gateway aggregates Swagger documentation from all microservices:
  - A single endpoint on the Gateway provides access to complete API documentation.

## How to Run the Application

### Prerequisites
- **Docker** and **Docker Compose** installed on your system.
- **Postman** for testing APIs (Postman collection included in the repository).

### Steps
1. Clone the repository:
   ```bash
   git clone git@github.com:Gone-M/comp3095_A_2.git
   cd comp3095_A_2
