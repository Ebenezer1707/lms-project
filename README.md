# Learning Management System (LMS)

## Overview
This is a simple Learning Management System (LMS) built using **Java**, **Spring Boot**, **MySQL**, and **Maven**. The system allows users to manage courses, enroll students, and perform user management tasks. It includes features such as:

- **User Management**: Admin can manage users (Add, Edit, Delete).
- **Course Management**: Admin can manage courses (Create, Update, Delete).
- **Enrollment**: Students can enroll in available courses.

## Features
- **User Roles**: Admin, Instructor, Student
- **Course Creation**: Instructors can create courses.
- **Enrollment**: Students can enroll in available courses.
- **Form Validation**: Client-side validation for forms using JavaScript.
- **CRUD Operations**: Basic CRUD functionality for users, courses, and enrollments.

## Technologies Used
- **Java**: Backend logic and user management.
- **Spring Boot**: Framework for building Java web applications.
- **MySQL**: Database for storing user, course, and enrollment information.
- **HTML/CSS**: Frontend to create responsive user interfaces.
- **JavaScript**: For form validation and interactivity.
- **Maven**: Dependency management and project build automation.

## Prerequisites
Before running the project, ensure that you have the following installed:
- **Java 8 or higher**: For running the Spring Boot application.
- **Maven**: For managing project dependencies.
- **MySQL**: For storing the data.
- **IDE**: Visual Studio Code (VS Code) or IntelliJ IDEA recommended.

## Setup and Installation

## Directory Structure

lms-project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
├── sql/
│   └── lms_schema.sql
├── pom.xml
├── README.md


### 1. Clone the Repository
Clone this repository to your local machine using Git:
```bash
git clone https://github.com/your-username/lms-project.git

