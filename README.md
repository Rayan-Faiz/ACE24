[Report.pdf](https://github.com/user-attachments/files/18245526/Report.pdf)
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

## Contributing
 To contribute:

Fork the repository
Create a new feature branch
Commit your changes
Open a pull request
