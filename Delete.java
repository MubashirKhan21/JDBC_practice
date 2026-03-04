package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");

			System.out.println("Driver software loaded");

			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudoperation", "postgres", "root");

			System.out.println(con);// address
			
			//create statement 
			Statement s = con.createStatement();
			
			//execute query 
			boolean res = s.execute("delete from employee where id = 103");
			System.out.println(res);
			} 
		catch (Exception e) {
			e.printStackTrace();
			}
		finally {
			try {
				//close the connection
				con.close();
				System.out.println("Connection is closed");
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

