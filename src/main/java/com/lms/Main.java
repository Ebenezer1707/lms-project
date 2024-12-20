package com.lms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LMSDao dao = new LMSDao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Add Course");
            System.out.println("4. Enroll Student in Course");
            System.out.println("5. View Enrollments");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();
                    dao.addStudent(name, email);
                    break;

                case 2:
                    dao.listStudents();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                case 4:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter course description: ");
                    String courseDescription = scanner.nextLine();
                    dao.addCourse(courseName, courseDescription); // Line 44
                    break;

                case 5:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseId = scanner.nextInt();
                    dao.enrollStudent(studentId, courseId); // Line 54
                    break;

                case 6:
                    dao.listEnrollments(); // Line 61
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
