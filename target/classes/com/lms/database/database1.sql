-- Create the database
CREATE DATABASE lmsdb;

-- Use the database
USE lmsdb;

-- Create Users table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('Admin', 'Instructor', 'Student') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Courses table
CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    instructor_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (instructor_id) REFERENCES users(id) ON DELETE SET NULL
);

-- Create Enrollments table
CREATE TABLE enrollments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);

-- Insert sample users
INSERT INTO users (name, email, password, role) VALUES
('Admin User', 'admin@lms.com', 'admin123', 'Admin'),
('John Doe', 'johndoe@lms.com', 'password123', 'Instructor'),
('Jane Smith', 'janesmith@lms.com', 'password123', 'Student'),
('Emily Davis', 'emilydavis@lms.com', 'password123', 'Student');

-- Insert sample courses
INSERT INTO courses (title, description, instructor_id) VALUES
('Java Programming', 'Learn the basics of Java programming.', 2),
('Spring Boot Framework', 'A comprehensive course on Spring Boot.', 2),
('Web Development', 'Introduction to HTML, CSS, and JavaScript.', 2);

-- Insert sample enrollments
INSERT INTO enrollments (student_id, course_id) VALUES
(3, 1), -- Jane Smith enrolled in Java Programming
(4, 2), -- Emily Davis enrolled in Spring Boot Framework
(3, 3), -- Jane Smith enrolled in Web Development
(4, 1); -- Emily Davis enrolled in Java Programming

