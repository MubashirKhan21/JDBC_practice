package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchUpdateExecution {

    public static void main(String[] args) {

        try {
            // 1. Load Driver
            Class.forName("org.postgresql.Driver");

            // 2. Establish Connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/demo",
                    "postgres",
                    "root"
            );

            // 3. SQL Query for update
            String sql = "UPDATE student SET percentage=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            // -------- First Update --------
            statement.setDouble(1, 85.5);
            statement.setInt(2, 101);
            statement.addBatch();

            // -------- Second Update --------
            statement.setDouble(1, 90.0);
            statement.setInt(2, 102);
            statement.addBatch();

            // -------- Third Update --------
            statement.setDouble(1, 75.75);
            statement.setInt(2, 103);
            statement.addBatch();

            // 4. Execute Batch
            int[] result = statement.executeBatch();

            System.out.println("Batch update executed successfully");
            System.out.println("Total records updated: " + result.length);

            // 5. Close Connection
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}