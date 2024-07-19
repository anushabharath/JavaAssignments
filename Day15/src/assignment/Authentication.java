package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Authentication {
    private static final String URL = "jdbc:sqlite:sample.db";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
                createTable(conn);
                insertUser(conn, "testUser", "testPassword");

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter User ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                if (authenticateUser(conn, userId, password)) {
                    System.out.println("Access Granted");
                } else {
                    System.out.println("Access Denied");
                }

                scanner.close();
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS User ("
                + "UserID TEXT PRIMARY KEY,"
                + "PasswordHash TEXT NOT NULL"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'User' created successfully.");
        }
    }

    private static void insertUser(Connection conn, String userId, String password) throws SQLException, NoSuchAlgorithmException {
        String hashedPassword = hashPassword(password);
        String sql = "INSERT INTO User (UserID, PasswordHash) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, hashedPassword);
            pstmt.executeUpdate();
            System.out.println("User inserted successfully.");
        }
    }

    private static boolean authenticateUser(Connection conn, String userId, String password) throws SQLException, NoSuchAlgorithmException {
        String hashedPassword = hashPassword(password);
        String sql = "SELECT * FROM User WHERE UserID = ? AND PasswordHash = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, hashedPassword);
            ResultSet rs = pstmt.executeQuery();

            return rs.next();
        }
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    }
}

