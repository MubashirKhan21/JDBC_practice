package com.qsp;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;

	public class BatchExecutionEx {

	    public static void main(String[] args) {

	        try {
	            // 1. Load Driver
	            Class.forName("org.postgresql.Driver");

	            // 2. Create Connection
	            Connection connection = DriverManager.getConnection(
	                    "jdbc:postgresql://localhost:5432/demo",
	                    "postgres",
	                    "root"
	            );

	            // 3. Prepare Statement
	            String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
	            PreparedStatement statement = connection.prepareStatement(sql);

	            // -------- First Student --------
	            statement.setInt(1, 103);
	            statement.setString(2, "king");
	            statement.setLong(3, 9565854851L);
	            statement.setDouble(4, 50.0);
	            statement.addBatch();

	            // -------- Second Student --------
	            statement.setInt(1, 104);
	            statement.setString(2, "ford");
	            statement.setLong(3, 8565856541L);
	            statement.setDouble(4, 75.0);
	            statement.addBatch();

	            // -------- Third Student --------
	            statement.setInt(1, 105);
	            statement.setString(2, "adams");
	            statement.setLong(3, 5696548585L);
	            statement.setDouble(4, 60.60);
	            statement.addBatch();

	            // 4. Execute Batch
	            statement.executeBatch();

	            System.out.println("Batch executed successfully");

	            // 5. Close connection
	            connection.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}