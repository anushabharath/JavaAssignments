package assignment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        Connection connection = dbManager.getConnection();

        try {
            // Use the connection to create a statement and execute queries
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM STUDENT";
            ResultSet resultSet = statement.executeQuery(query);

            // Handle the result set as needed
            while (resultSet.next()) {
                // Process each row of the result set
                System.out.println("Column1: " + resultSet.getString("studentid"));
                System.out.println("Column2: " + resultSet.getString("studentname"));
                // Add more columns as needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection (optional, since it will be reused, but good practice)
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
