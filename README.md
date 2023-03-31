# Insurance Management Platform with Spring Boot and Java

This is an insurance management platform that allows users to manage insurance policies, clients, and claims using Spring Boot and Java.

## Technologies Used
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Java 11

## Geting Started
1. Clone the project:
`git clone https://github.com/<username>/insurance-management.git`
2. Navigate to the project directory: `cd insurance-management
`
3. Build the project `mvn clean install`
4. Run the project `mvn spring-boot:run`
5. The application will start running on `http://localhost:8080`

## API Endpoints
### Clients
- GET `/api/clients`: Fetch all clients.
- GET `/api/clients/{id}`: Fetch a specific client by ID.
- POST `/api/clients`: Create a new client.
- PUT `/api/clients/{id}`: Update a client's information.
- DELETE `/api/clients/{id}`: Delete a client.
### Insurance Policies
- GET `/api/policies`: Fetch all insurance policies.
- GET `/api/policies/{id}`: Fetch a specific insurance policy by ID.
- POST `/api/policies`: Create a new insurance policy.
- PUT `/api/policies/{id}`: Update an insurance policy.
- DELETE `/api/policies/{id}`: Delete an insurance policy.
### Claims
- GET `/api/claims`: Fetch all claims.
- GET `/api/claims/{id}`: Fetch a specific claim by ID.
- POST `/api/claims`: Create a new claim.
- PUT `/api/claims/{id}`: Update a claim's information.
- DELETE `/api/claims/{id}`: Delete a claim.

## Exception Handling and Validation
- `ResourceNotFoundException`: Thrown when a resource is not found in the database.
- `BadRequestException`: Thrown when the request body is not valid.
- `DataIntegrityViolationException`: Thrown when there is a violation of the data integrity rules (e.g., unique constraint violation).
- `MethodArgumentNotValidException`: Thrown when the request body fails validation.
- `ExceptionHandler`: Global exception handler to handle all exceptions and return a consistent error response.
Security
- There is no authentication or authorization implemented in this version.
Unit Tests
- Unit tests for the APIs and services have been written using JUnit and Mockito.
- Run the tests using:`mvn test`
