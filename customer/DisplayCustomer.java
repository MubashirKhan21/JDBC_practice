package customer;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayCustomer {

    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/demo?user=postgres&password=root";

            Connection connection = DriverManager.getConnection(url);

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(
                    "select * from student where id=11");

            rs.next();

            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getLong(3));
            System.out.println(rs.getDouble(4));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
