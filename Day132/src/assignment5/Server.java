/*Task 5: Java Networking and Serialization
Develop a basic TCP client and server application where the client sends a serialized object with 2 numbers and operation  to be performed on them to the server, and the server computes the result and sends it back to the client. for eg, we could send  2, 2, ""+"" which would mean 2 + 2
*/

package assignment5;

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
