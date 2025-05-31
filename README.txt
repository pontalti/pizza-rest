# 🍕 Pizza REST API

A Spring Boot application using MVC architecture, Bootstrap, jQuery, and RESTful APIs with JWT-based authentication and role-based access control.

---

## 🌐 Application Overview

- **Framework**: Spring Boot  
- **Frontend**: Bootstrap + jQuery  
- **Authentication**: JWT (JSON Web Tokens)  
- **Access Roles**: `user`, `admin`

---

## 🚀 Run the Application

Once the application is running, you can access the frontend and API at:

```
http://localhost:8080
```

---

## 🔐 Authentication

Use the following credentials to obtain a JWT token:

**Endpoint:**
```
POST http://localhost:8080/auth
```

**Request Body:**
```json
{
  "username": "user",
  "password": "password"
}
```
_or_
```json
{
  "username": "admin",
  "password": "admin"
}
```

---

## 🔁 Refresh Token

**Endpoint:**
```
POST http://localhost:8080/refresh
```

Include the token in the header:
```
Authorization: Bearer <YOUR_JWT_TOKEN>
```

---

## 🍽️ REST API Endpoints

All REST endpoints require a valid JWT token in the header:
```
Authorization: Bearer <YOUR_JWT_TOKEN>
```

### 📋 List All Pizzas
```
GET http://localhost:8080/pizza
```

### 🔍 Get Pizza by Name
```
GET http://localhost:8080/pizza/{name}
```

### 🔒 Admin Only Endpoint
This route is protected and accessible only to users with the `admin` role:
```
GET http://localhost:8080/admin
```

---

## 📚 Notes

- Ensure JWT token is included in every secured request.
- Use a REST client like Postman to test the API with headers and body configurations.

