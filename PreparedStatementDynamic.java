package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//
//public class PreparedStatementDynamic {
//    public static void main(String[] args) {
//
//        String url = "jdbc:postgresql://localhost:5432/demo";
//        String user = "postgres";
//        String password = "root";
//
//        String sql = "INSERT INTO student (id, name, mobile, percentage) VALUES (?, ?, ?, ?)";
//
//        try (
//            Scanner sc = new Scanner(System.in);
//            Connection con = DriverManager.getConnection(url, user, password);
//            PreparedStatement p = con.prepareStatement(sql)
//        ) {
//
//            System.out.print("Enter ID: ");
//            int id = sc.nextInt();
//            sc.nextLine(); // consume newline
//
//            System.out.print("Enter Name: ");
//            String name = sc.nextLine();
//
//            System.out.print("Enter Mobile Number: ");
//            long mobile = sc.nextLong();
//
//            System.out.print("Enter Percentage: ");
//            double percentage = sc.nextDouble();
//
//            p.setInt(1, id);
//            p.setString(2, name);
//            p.setLong(3, mobile);
//            p.setDouble(4, percentage);
//
//            int rows = p.executeUpdate();
//            System.out.println("Rows inserted: " + rows);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
public class PreparedStatementDynamic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== STUDENT MENU ======");
            System.out.println("1. Insert Student");
            System.out.println("2. Update Student Percentage");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Select the choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Mobile Number: ");
                    long mobile = sc.nextLong();

                    System.out.print("Enter Percentage: ");
                    double percentage = sc.nextDouble();

                    Controller.insertStudent(id, name, mobile, percentage);
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter new Percentage: ");
                    double newPercentage = sc.nextDouble();

                    Controller.updateStudent(uid, newPercentage);
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int did = sc.nextInt();

                    Controller.deleteStudent(did);
                    break;

                case 4:
                    Controller.viewStudents();
                    break;

                case 5:
                    System.out.println("Thank you...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}