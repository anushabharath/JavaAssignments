package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {

    // Private static instance of the class
    private static volatile DatabaseConnectionManager instance;
    
    // Database connection URL, username and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/wipro";
    private static final String USER = "root";
    private static final String PASS = "rps@123";
    
    // Private constructor to prevent instantiation
    private DatabaseConnectionManager() {
        // Prevent instantiation from reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }
    
    // Public static method to provide access to the instance
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
    
    // Method to get a database connection
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
