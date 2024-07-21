package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    public static void main(String[] args) {
        Connection con = null;
        try {
            // Load the MySQL JDBC driver (optional with modern JDBC drivers)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            String URL = "jdbc:mysql://localhost:3306/wiprol";
            String user = "root";
            String password = "rps@123";
            con = DriverManager.getConnection(URL, user, password);

            // Print the connection object to confirm successful connection
            System.out.println("Connected to MySQL database: " + con);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred.");
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close the connection.");
                    e.printStackTrace();
                }
            }
        }
    }
}
