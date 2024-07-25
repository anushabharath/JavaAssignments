package assignment;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        Connection connection = dbManager.getConnection();
        
        // Use the connection
        if (connection != null) {
            System.out.println("Connection established!");
        } else {
            System.out.println("Failed to establish connection.");
        }
        
        // Don't forget to close the connection when done
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
