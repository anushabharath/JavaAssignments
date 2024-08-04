/*Task 3: New IO (NIO)
Use NIO Channels and Buffers to read content from a file and write to another file.
*/

package assignment3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileCopyNIO {
    public static void main(String[] args) {
        // Define the input and output file paths
        Path inputFile = Path.of("D:\\input1.txt");
        Path outputFile = Path.of("D:\\output1.txt");

        // Try-with-resources to ensure channels are closed after the operation
        try (FileChannel inputChannel = FileChannel.open(inputFile, StandardOpenOption.READ);
             FileChannel outputChannel = FileChannel.open(outputFile, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
             
            // Allocate a ByteBuffer with a specified capacity
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            
            // Read data from input file and write to output file
            while (inputChannel.read(buffer) > 0) {
                buffer.flip();  // Prepare the buffer for reading
                outputChannel.write(buffer);
                buffer.clear();  // Prepare the buffer for writing
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
