# Patient Monitoring and Localization System  

A microservices-based platform for monitoring patients' safety using IoT , built with **Spring Boot** for the backend and **React** for the frontend. This system allows administrators to manage patients, monitor their locations , and receive notifications when patients leave their designated safe zones or stay for too long in one zone.

---

## Table of Contents

- [Software Architecture](#software-architecture)
- [Frontend](#frontend)
- [Backend](#backend)
- [Features](#features)
- [Contributing](#contributing)

---

## Software Architecture
![software architechture](https://github.com/user-attachments/assets/3f9c50c2-bd4a-4fe2-a010-eb778c1fb3a5)
This app has 4 microservices:

Authentication Service: For user authentication and login.
Patient Service: Manages patient details and their safe zones.
Location Service: Tracks GPS locations of patients from IoT devices.
Alert Service: Checks if patients are out of their safe zones and sends notifications.
The app is built with Spring Boot for the backend and React for the frontend.

Frontend Interaction:

Caregivers use the React frontend to log in, manage patients, view their locations on a map, and see notifications.
Data Flow:

GPS devices send patient location data to the Location Service.
The Alert Service processes the location data and checks against safe zones.
Notifications are displayed in the caregiver’s dashboard.

## Technology Stack:

Backend: Spring Boot (4 services)
Frontend: React
Database: MySQL (shared by all services)
Communication: Feign (for service communication)
Service Discovery: Eureka
 ## Frontend
Technologies Used:
React
Axios for API calls
Bootstrap for responsive design
## Backend
Technologies Used:
Spring Boot for microservices
Spring Cloud Eureka for service discovery
Feign Clients for inter-service communication
MySQL for data storage

## features
Admin Dashboard:
Manage caregivers and patients with CRUD operations.
Patient Management:
Add, update, and view patient details, including their safe zones
Tracking:
cheking patient locations / safe zone
Alerts & Notifications:
Receive notifications when a patient doesn't exit their safe zone (type of alert : safe zone breach)
Receive alert when they haven't moved from the same place during 2 days (Unusual movement)
Alerts have 3 states : new / acknowledge / resolved

## Docker-compose file
```sh
services:

  mysql-database:
    image: mysql
    container_name: mysql-database
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: db
      MYSQL_USER: root
      MYSQL_PASSWORD: root
    networks:
      - microservices-network
    volumes:
      - mysql-data:/var/lib/mysql
    healthcheck:
      test: ["CMD", "ls"]
      interval: 30s
      timeout: 5s
      retries: 3
      start_period: 60s

  eureka-server:
    build:
      context: ./eureka
    ports:
      - "8761:8761"
    networks:
      - microservices-network
    healthcheck:
      test: ["CMD", "ls"]
      interval: 10s
      timeout: 5s
      retries: 3
      start_period: 30s


  auth-service:
    build:
      context: ./springboot-jwt-auth
    ports:
      - "8089:8089"
    networks:
      - microservices-network
    healthcheck:
      test: ["CMD", "ls"]
      interval: 10s
      timeout: 5s
      retries: 3
      start_period: 30s

  patient-service:
    build:
      context: ./PatientManagement
    ports:
      - "8081:8081"
    depends_on:
      auth-service:
        condition: service_healthy
    networks:
      - microservices-network
    healthcheck:
      test: ["CMD", "ls"]
      interval: 10s
      timeout: 5s
      retries: 3
      start_period: 30s

  location-service:
    build:
      context: ./LocationManagement
    ports:
      - "8082:8082"
    depends_on:
      patient-service:
        condition: service_healthy
    networks:
      - microservices-network
    healthcheck:
      test: ["CMD", "ls"]
      interval: 10s
      timeout: 5s
      retries: 3
      start_period: 30s

  alert-service:
    build:
      context: ./AlertManagement
    ports:
      - "8083:8083"
    depends_on:
      location-service:
        condition: service_healthy
    networks:
      - microservices-network
    healthcheck:
      test: ["CMD", "ls"]
      interval: 10s
      timeout: 5s
      retries: 3
      start_period: 30s

networks:
  microservices-network:

volumes:
  mysql-data:
```
 

## Contributing
 To contribute:

Fork the repository
Create a new feature branch
Commit your changes
Open a pull request
