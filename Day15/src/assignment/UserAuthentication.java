package assignment;

import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UserAuthentication {

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

            // Create table 'User'
            createTable(con);

            // Insert sample user data
            insertUser(con, "testuser", "password123");

            // Accept user input for authentication
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter User ID: ");
            String userID = scanner.nextLine();
            System.out.print("Enter Password: ");
            String userPassword = scanner.nextLine();

            // Authenticate user
            if (authenticateUser(con, userID, userPassword)) {
                System.out.println("User access allowed.");
            } else {
                System.out.println("User access denied.");
            }

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

    private static void createTable(Connection con) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS User ("
                              + "UserID VARCHAR(255) PRIMARY KEY, "
                              + "PasswordHash VARCHAR(255))";
        try (Statement stmt = con.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }

    private static void insertUser(Connection con, String userID, String password) throws SQLException {
        String insertUserSQL = "INSERT INTO User (UserID, PasswordHash) VALUES (?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insertUserSQL)) {
            pstmt.setString(1, userID);
            pstmt.setString(2, hashPassword(password));
            pstmt.executeUpdate();
        }
    }

    private static boolean authenticateUser(Connection con, String userID, String password) throws SQLException {
        String query = "SELECT PasswordHash FROM User WHERE UserID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, userID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("PasswordHash");
                    return storedHash.equals(hashPassword(password));
                }
            }
        }
        return false;
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found.");
        }
    }
}
