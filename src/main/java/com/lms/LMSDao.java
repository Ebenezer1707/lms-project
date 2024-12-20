package com.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LMSDao {
    public void addStudent(String name, String email) {
        String query = "INSERT INTO students (name, email) VALUES (?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();

            System.out.println("Student added successfully!");
        } catch (SQLException e) {
        }
    }

    public void listStudents() {
        String query = "SELECT * FROM students";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                                   ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
        }
    }

    public void addCourse(String name, String description) {
        String query = "INSERT INTO courses (name, description) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, name);            
            stmt.setString(2, description);    
            stmt.executeUpdate();              
            System.out.println("Course added successfully!"); 
        } catch (SQLException e) {
            e.printStackTrace();               
        }
    }

    public void enrollStudent(int studentId, int courseId) { // Line 82 (approx.)
        String query = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setInt(1, studentId);         // Line 85
            stmt.setInt(2, courseId);          // Line 86
            stmt.executeUpdate();              // Line 87
            System.out.println("Student enrolled in course successfully!"); // Line 88
        } catch (SQLException e) {
            e.printStackTrace();               // Line 90
        }
    }

    public void listEnrollments() {           // Line 94 (approx.)
        String query = "SELECT s.name AS student_name, c.name AS course_name " +
                       "FROM enrollments e " +
                       "JOIN students s ON e.student_id = s.id " +
                       "JOIN courses c ON e.course_id = c.id";
    
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
    
            while (rs.next()) {                // Line 100
                System.out.println("Student: " + rs.getString("student_name") +
                                   ", Course: " + rs.getString("course_name")); // Line 102
            }
        } catch (SQLException e) {
            e.printStackTrace();               // Line 105
        }
    }
        
}

