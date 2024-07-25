package assignment;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {
            
            // Get input from user
            System.out.print("Enter the first number: ");
            double number1 = scanner.nextDouble();
            System.out.print("Enter the second number: ");
            double number2 = scanner.nextDouble();
            System.out.print("Enter the operation (+, -, *, /): ");
            String operator = scanner.next();
            
            // Create an Operation object
            Operation operation = new Operation(number1, number2, operator);
            
            // Send the Operation object to the server
            output.writeObject(operation);
            output.flush();
            
            // Receive the result from the server
            double result = input.readDouble();
            System.out.println("Result: " + result);
            
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
