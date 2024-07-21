package assignment;

import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Authentication {

    public static void main(String[] args) {
        Connection con = null;
        try {
            // Load the MySQL JDBC driver (optional with modern JDBC drivers)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            String URL = "jdbc:mysql://localhost:3306/user";
            String user = "root";
            String password = "rps@123";
            con = DriverManager.getConnection(URL, user, password);

            // Create table if it does not exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS User ("
                    + "UserID VARCHAR(255) NOT NULL, "
                    + "PasswordHash VARCHAR(255) NOT NULL, "
                    + "PRIMARY KEY (UserID))";
            Statement stmt = con.createStatement();
            stmt.execute(createTableSQL);

            // Accept user input for UserID and Password
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter User ID: ");
            String inputUserID = scanner.nextLine();
            System.out.print("Enter Password: ");
            String inputPassword = scanner.nextLine();

            // Hash the password
            String passwordHash = hashPassword(inputPassword);

            // Check if user exists with the given UserID and Password
            String query = "SELECT * FROM User WHERE UserID = ? AND PasswordHash = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, inputUserID);
            pstmt.setString(2, passwordHash);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Access Granted");
            } else {
                System.out.println("Access Denied");
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

    // Method to hash a password using SHA-256
    public static String hashPassword(String password) {
        String hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error hashing password");
            e.printStackTrace();
        }
        return hashedPassword;
    }
}
