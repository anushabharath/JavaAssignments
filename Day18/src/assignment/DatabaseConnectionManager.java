package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    // Private static variable of single instance of the class
    private static volatile DatabaseConnectionManager instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/wipro";
    private String username = "rps";
    private String password = "rps@123";

    // Private constructor to restrict instantiation from other classes
    private DatabaseConnectionManager() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    // Public static method that returns the instance of the class
    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionManager.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionManager();
                }
            }
        }
        return instance;
    }

    // Public method to get the database connection
    public Connection getConnection() {
        return connection;
    }
}
