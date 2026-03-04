package com.qsp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.postgresql.Driver;

public class Work {

    public static void main(String[] args) {

        Connection con = null;

        try {
            // Register driver
            DriverManager.registerDriver(new Driver());
            System.out.println("Driver software registered");

            // Load properties file
            FileInputStream s = new FileInputStream("db.properties");

            Properties p = new Properties();
            p.load(s);

            String url = p.getProperty("url");      // make sure lowercase
            String user = p.getProperty("user");
            String password = p.getProperty("password");

            // Establish connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println(con);

            // Create statement
            Statement st = con.createStatement();

            // Execute insert query
            boolean res = st.execute("insert into student values(107,'Sahil',9146775342,'shaikhsahil0793@gmail.com')");

            System.out.println(res);

        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection is closed");
                }
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}