# Address Book Application

A RESTful web application built with **Spring Framework** (not Spring Boot) for managing address book entries. This application demonstrates the use of Spring MVC, Spring Data JPA, Hibernate, and H2 database.

## 📋 Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Usage Examples](#usage-examples)
- [Configuration](#configuration)
- [Database](#database)

## ✨ Features

- **CRUD Operations**: Create, Read, Update, and Delete address entries
- **Search Functionality**: Search addresses by name
- **Filter by City**: Get all addresses from a specific city
- **RESTful API**: Clean REST API design with proper HTTP methods
- **H2 Database**: In-memory database for easy testing and development
- **JPA/Hibernate**: Object-Relational Mapping for database operations
- **DTO Pattern**: Data Transfer Objects for clean API responses
- **Spring Configuration**: Java-based configuration (no XML)

## 🛠️ Technologies Used

- **Java**: 17
- **Spring Framework**: 6.1.0
  - Spring Core
  - Spring Context
  - Spring Web MVC
  - Spring ORM
- **Spring Data JPA**: 3.2.0
- **Hibernate**: 6.3.1.Final
- **H2 Database**: 2.2.224 (In-memory)
- **Jackson**: 2.15.3 (JSON processing)
- **Maven**: Build tool and dependency management
- **Jakarta EE**: Servlet API, Persistence API, Validation API

## 📁 Project Structure

```
day8/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── addressbook/
│                   ├── Main.java                      # Application entry point
│                   ├── config/
│                   │   ├── AppConfig.java            # Spring application configuration
│                   │   ├── WebAppInitializer.java    # Web application initializer
│                   │   └── WebConfig.java            # Web MVC configuration
│                   ├── controller/
│                   │   └── AddressBookController.java # REST API endpoints
│                   ├── dto/
│                   │   └── AddressBookDTO.java       # Data Transfer Object
│                   ├── model/
│                   │   └── Address.java              # JPA Entity
│                   ├── repository/
│                   │   └── AddressRepository.java    # Data access layer
│                   └── service/
│                       └── AddressBookService.java   # Business logic
└── pom.xml                                           # Maven configuration
```

## 📦 Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 17 or higher
- **Apache Maven**: Version 3.6 or higher
- **Servlet Container**: Apache Tomcat 10.x, Jetty 11.x, or any Jakarta EE 9+ compatible container
- **IDE** (Optional): IntelliJ IDEA, Eclipse, or VS Code

## 🚀 Installation & Setup

### 1. Clone or Download the Project

```bash
cd C:\Users\allab\OneDrive\Pictures\bridgelabz2\day8
```

### 2. Build the Project

```bash
mvn clean install
```

This will:
- Compile the Java source code
- Run tests (if any)
- Package the application as a WAR file

### 3. Locate the WAR File

After successful build, the WAR file will be available at:
```
target/day8-1.0-SNAPSHOT.war
```

## 🏃 Running the Application

### Option 1: Deploy to Apache Tomcat

1. Copy the WAR file to Tomcat's `webapps` directory:
   ```bash
   copy target\day8-1.0-SNAPSHOT.war %CATALINA_HOME%\webapps\
   ```

2. Start Tomcat:
   ```bash
   %CATALINA_HOME%\bin\startup.bat
   ```

3. Access the application at:
   ```
   http://localhost:8080/day8-1.0-SNAPSHOT/api/addresses
   ```

### Option 2: Deploy to Jetty

1. Copy the WAR file to Jetty's `webapps` directory

2. Start Jetty and access the application

### Option 3: Use IDE Integration

Most IDEs (IntelliJ IDEA, Eclipse) have built-in support for deploying WAR files to application servers.

## 🔌 API Endpoints

### Base URL
```
http://localhost:8080/day8-1.0-SNAPSHOT/api/addresses
```

### Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/addresses` | Get all addresses |
| `GET` | `/api/addresses/{id}` | Get address by ID |
| `POST` | `/api/addresses` | Create new address |
| `PUT` | `/api/addresses/{id}` | Update existing address |
| `DELETE` | `/api/addresses/{id}` | Delete address |
| `GET` | `/api/addresses/search?name={name}` | Search addresses by name |
| `GET` | `/api/addresses/city/{city}` | Get addresses by city |

## 📝 Usage Examples

### Create a New Address

**Request:**
```bash
curl -X POST http://localhost:8080/day8-1.0-SNAPSHOT/api/addresses \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "phone": "+1-555-1234",
    "email": "john.doe@example.com",
    "street": "123 Main Street",
    "city": "New York",
    "state": "NY",
    "zipCode": "10001",
    "country": "USA"
  }'
```

**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "phone": "+1-555-1234",
  "email": "john.doe@example.com",
  "street": "123 Main Street",
  "city": "New York",
  "state": "NY",
  "zipCode": "10001",
  "country": "USA"
}
```

### Get All Addresses

**Request:**
```bash
curl http://localhost:8080/day8-1.0-SNAPSHOT/api/addresses
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "phone": "+1-555-1234",
    "email": "john.doe@example.com",
    "street": "123 Main Street",
    "city": "New York",
    "state": "NY",
    "zipCode": "10001",
    "country": "USA"
  }
]
```

### Get Address by ID

**Request:**
```bash
curl http://localhost:8080/day8-1.0-SNAPSHOT/api/addresses/1
```

### Update Address

**Request:**
```bash
curl -X PUT http://localhost:8080/day8-1.0-SNAPSHOT/api/addresses/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "phone": "+1-555-9999",
    "email": "john.updated@example.com",
    "street": "456 Oak Avenue",
    "city": "New York",
    "state": "NY",
    "zipCode": "10002",
    "country": "USA"
  }'
```

### Delete Address

**Request:**
```bash
curl -X DELETE http://localhost:8080/day8-1.0-SNAPSHOT/api/addresses/1
```

### Search by Name

**Request:**
```bash
curl http://localhost:8080/day8-1.0-SNAPSHOT/api/addresses/search?name=John
```

### Get Addresses by City

**Request:**
```bash
curl http://localhost:8080/day8-1.0-SNAPSHOT/api/addresses/city/New%20York
```

## ⚙️ Configuration

### Application Configuration

The application uses Java-based configuration:

- **AppConfig.java**: Main Spring configuration including JPA and transaction management
- **WebConfig.java**: Spring MVC configuration with JSON message converters
- **WebAppInitializer.java**: Servlet 3.0+ programmatic configuration (replaces web.xml)

### Database Configuration

The application uses an in-memory H2 database with the following default settings:

- **JDBC URL**: `jdbc:h2:mem:addressbook`
- **Username**: `sa`
- **Password**: *(empty)*
- **Hibernate DDL**: `update` (auto-creates tables)
- **SQL Logging**: Enabled in console

To modify database settings, edit the `AppConfig.java` file.

## 🗄️ Database

### H2 Console (Optional)

To enable H2 console for database inspection:

1. Add H2 console configuration in your web configuration
2. Access at: `http://localhost:8080/day8-1.0-SNAPSHOT/h2-console`

### Database Schema

The application automatically creates the following table:

```sql
CREATE TABLE addresses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    phone VARCHAR(255),
    email VARCHAR(255),
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zip_code VARCHAR(255),
    country VARCHAR(255)
);
```

## 🏗️ Architecture

This application follows a layered architecture:

1. **Controller Layer**: Handles HTTP requests and responses
2. **Service Layer**: Contains business logic and DTO conversion
3. **Repository Layer**: Data access using Spring Data JPA
4. **Model Layer**: JPA entities representing database tables
5. **DTO Layer**: Data Transfer Objects for API communication

