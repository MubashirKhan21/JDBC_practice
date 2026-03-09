package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTCL {

    public static boolean isSuccess() {
        return false;// change this to true to simulate payment failure
    }

    public static void main(String[] args) {

        String booking_info = "insert into booking_info values(101,'Emirates','Mumbai','Dubai')";
        String passenger_info = "insert into passenger_info values(201,'Mubashir Khan',9767874082,'mubashirkhan9097@gmail.com')";
        String payment_info = "insert into payment_info values(301,65500,'online')";

        Connection connection = null;

        try {

            // Load Driver
            Class.forName("org.postgresql.Driver");

         // Establish Connection
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/transcations",
                    "postgres",
                    "root"
            );

            // Disable Auto Commit
            connection.setAutoCommit(false);

            // Insert booking info
            Statement statement1 = connection.createStatement();
            statement1.execute(booking_info);

            // Insert passenger info
            Statement statement2 = connection.createStatement();
            statement2.execute(passenger_info);

            if (!isSuccess()) {

                // Insert payment info
                Statement statement3 = connection.createStatement();
                statement3.execute(payment_info);

                // Commit transaction
                connection.commit();
                System.out.println("Booking Confirmed");

            } else {

                // Rollback transaction
                connection.rollback();
                System.out.println("Payment not done. Transaction rolled back.");
            }

        } catch (ClassNotFoundException | SQLException e) {

            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("Transaction rolled back due to exception");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}