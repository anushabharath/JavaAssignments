package serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEx
{
    public static void main(String args[]) throws IOException {
        Employee emp1 = new Employee(111,"Ram",21);
        FileOutputStream fo = new FileOutputStream("D:\\employee.ser");
        ObjectOutputStream out = new ObjectOutputStream(fo);
        out.writeObject(emp1);
        System.out.println("Serialization done for Employee in the file employee.ser ");

    }
}