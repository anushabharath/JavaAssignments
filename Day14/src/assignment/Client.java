package assignment;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            // Create an Operation object to send to the server
            Operation operation = new Operation(2, 2, "+");

            // Send the Operation object
            output.writeObject(operation);

            // Receive the result from the server
            double result = (double) input.readObject();
            System.out.println("Result: " + result);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
