package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementEx {
    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement p = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/demo",
                    "postgres",
                    "root");

            // 4 columns → 4 placeholders
            p = con.prepareStatement(
                    "INSERT INTO student (id, name, mobile, percentage) VALUES (?, ?, ?, ?)");

            p.setInt(1, 202);
            p.setString(2, "Junaid");
            p.setLong(3, 784562587L);  // bigint → use setLong()
            p.setDouble(4, 10.5);

            int rows = p.executeUpdate();   // use executeUpdate() for INSERT
            System.out.println("Rows inserted: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}