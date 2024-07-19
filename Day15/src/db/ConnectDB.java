package db;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class ConnectDB
{
    public static void main(String args[]) throws ClassNotFoundException, SQLException {

        try
        {
            Connection connection = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/wipro", "root", "pushpa123");
            System.out.println("Connected");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name");
            String name = sc.nextLine();

            System.out.println("Enter password");
            String password = sc.nextLine();
            System.out.println("Enter id");
            int id = sc.nextInt();

            String insertQuery = "insert into student(student_id,student_name,student_password) values(?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,password);
            int x = pstmt.executeUpdate();
            if(x>0)
                System.out.println("Inserted Successfully");
            else

                System.out.println("Could Not able to Insert");




        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

