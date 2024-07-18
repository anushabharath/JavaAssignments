package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationEx
{
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream("D:\\employee.ser");
        ObjectInputStream oi = new ObjectInputStream(fi);
        Employee e =(Employee)oi.readObject();
        System.out.println("Deserialized Objects Value "+ e.getId()+" "+e.getName()+" "+e.getAge());

    }
}

