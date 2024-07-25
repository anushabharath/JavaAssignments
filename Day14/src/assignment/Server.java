package assignment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345...");
            
            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())) {
                    
                    // Read the Operation object from the client
                    Operation operation = (Operation) input.readObject();
                    
                    // Perform the operation
                    double result = operation.performOperation();
                    
                    // Send the result back to the client
                    output.writeDouble(result);
                    output.flush();
                    
                    System.out.println("Received operation: " + operation.getNumber1() + " " + operation.getOperator() + " " + operation.getNumber2());
                    System.out.println("Sent result: " + result);
                } catch (ClassNotFoundException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
