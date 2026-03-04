package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller {

    private static final String URL = "jdbc:postgresql://localhost:5432/demo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    // 1. INSERT STUDENT
    public static void insertStudent(int id, String name, long mobile, double percentage) {

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setLong(3, mobile);
            statement.setDouble(4, percentage);

            statement.executeUpdate();
            System.out.println("Student inserted successfully");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. UPDATE STUDENT
    public static void updateStudent(int id, double percentage) {

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "UPDATE student SET percentage=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setDouble(1, percentage);
            statement.setInt(2, id);

            statement.executeUpdate();
            System.out.println("Student updated successfully");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. DELETE STUDENT
    public static void deleteStudent(int id) {

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "DELETE FROM student WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Student deleted successfully");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. VIEW STUDENTS
    public static void viewStudents() {

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT * FROM student";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            System.out.println("\nID  NAME   MOBILE   PERCENTAGE");
            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + "  " +
                        rs.getString(2) + "  " +
                        rs.getLong(3) + "  " +
                        rs.getDouble(4)
                );
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}