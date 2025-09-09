# Task Management System

## Overview
Task Management API is a **Spring Boot RESTful application** developed as a college assignment.  
It allows users to create, list, search, update, and delete tasks stored in a relational database.  
Each task contains:
- Title
- Due Date
- Assignee (responsible person)

The project follows the professor’s requirement of using **Model, Repository, and Controller** only.

---

## Features
- Add new tasks with **automatic ID generation**
- List all registered tasks
- Retrieve a task by its ID
- Update existing tasks
- Delete tasks
- RESTful API endpoints tested via Postman

---

## Technologies Used
- **Java 17+**
- **Spring Boot** (Web, Data JPA)
- **MySQL** (relational database)
- **Lombok** (to reduce boilerplate code)
- **Postman** (for API testing)

---

## Requirements
- **Java Development Kit (JDK) 17 or higher**  
  Check your version with:
  ```bash
  java -version
  ```
- **Maven 3.8+** (for building the project)
- **MySQL Server** running locally or remotely  
- **Postman** or similar tool for testing the API endpoints

---

## Installation
1. Clone the repository:
   ```bash
   git clone git@github.com:ryanoviski/task-management-system.git
   ```
2. Navigate to the project folder:
   ```bash
   cd task-management-system
   ```
3. Configure your MySQL database and update `application.properties` with your credentials.
4. Build and run the project with Maven:
   ```bash
   mvn spring-boot:run
   ```

---

## How to Use
- Run the project with Maven or inside your IDE (IntelliJ/Eclipse).  
- Use **Postman** to test the endpoints:
  - Send JSON requests to `/api/tasks`
  - View responses with task data or status codes (200, 201, 204, 404).  

---

## Contributions
This project was developed strictly following college assignment requirements.  

---

## License
This project is licensed under the MIT License (LICENSE).

---

## Contact
Ryan dos Santos — ryanoviski@gmail.com  
GitHub: [https://github.com/ryanoviski](https://github.com/ryanoviski)
