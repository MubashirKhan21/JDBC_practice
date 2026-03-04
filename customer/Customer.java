package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {

    public static void main(String[] args) {

        Connection c = null;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver software loaded");

            c = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/demo",
                    "postgres",
                    "root");

            System.out.println(c);

            Statement s = c.createStatement();
            boolean res = s.execute(
                    "insert into student values(11,'Mubashir',12356785,60)");

            System.out.println(res);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
