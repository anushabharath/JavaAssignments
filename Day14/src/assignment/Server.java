package assignment;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())) {

                    Operation operation = (Operation) input.readObject();
                    double result = performOperation(operation);

                    output.writeObject(result);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double performOperation(Operation operation) {
        double number1 = operation.getNumber1();
        double number2 = operation.getNumber2();
        String operator = operation.getOperator();

        return switch (operator) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "/" -> number1 / number2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}

