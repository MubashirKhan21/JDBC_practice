package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class Regester {

    public static void main(String[] args) {

        Connection con = null;

        try {
            // register the driver software
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            System.out.println("Driver software registered");

            // establish the connection
            con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/crudoperation?user=postgres&password=root");

            System.out.println(con);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                // close the connection
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