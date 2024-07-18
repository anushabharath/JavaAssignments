package fileoperations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile
{
    public static void main(String args[]) throws IOException {

        FileOutputStream fo = new FileOutputStream("D:\\names.txt");
        String names = "Hello, World , Core, Java ";
        byte arr[] = names.getBytes();
        fo.write(arr);
        fo.close();


    }
}
