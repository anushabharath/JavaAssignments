package assignment;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        Connection connection = dbManager.getConnection();

        try {
            // Use the connection to create a statement and execute queries
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM wipro";
            statement.executeQuery(query);
            // Handle the result set as needed
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
