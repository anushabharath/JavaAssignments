package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    // Static variable reference of single_instance of type DatabaseConnectionManager
    private static DatabaseConnectionManager singleInstance = null;
    private Connection connection;

    // Private constructor to restrict instantiation of the class from other classes
    private DatabaseConnectionManager() {
        try {
            // Initialize the database connection here (replace with actual database details)
            String url = "jdbc:mysql://localhost:3306/wipro";
            String username = "root";
            String password = "rps@123";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Static method to create instance of DatabaseConnectionManager class
    public static DatabaseConnectionManager getInstance() {
        if (singleInstance == null) {
            synchronized (DatabaseConnectionManager.class) {
                if (singleInstance == null) {
                    singleInstance = new DatabaseConnectionManager();
                }
            }
        }
        return singleInstance;
    }

    public Connection getConnection() {
        return connection;
    }
}
