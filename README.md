# Student Management REST API

A RESTful API built with Java and Spring Boot for managing 
student records with full CRUD operations.

## Tech Stack
Java 17 | Spring Boot 3 | MySQL | JPA/Hibernate | Maven | Deployed on Railway

## Live API
Base URL: [Coming soon — deploying this week]

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /students | Get all students |
| GET | /students/{id} | Get student by ID |
| POST | /students | Create new student |
| PUT | /students/{id} | Update student |
| DELETE | /students/{id} | Delete student |

## Run Locally

1. Clone the repo
   git clone https://github.com/pavan-softaware-dev/student-management-api

2. Create MySQL database
   CREATE DATABASE studentdb;

3. Update src/main/resources/application.properties
   with your MySQL username and password

4. Run the project
   mvn spring-boot:run

## Author
[Pavan Godavarthi] — MCA Graduate | Java Backend Developer
GitHub: github.com/pavan-software-dev
