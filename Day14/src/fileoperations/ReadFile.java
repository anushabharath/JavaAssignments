package fileoperations;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile
{
    public static void main(String args[]) throws IOException
    {
        FileInputStream fi = new FileInputStream("D:\\names.txt") ;
        int i =0;
        while((i = fi.read())!= -1)
        {
         System.out.print((char)i);
        }
        fi.close();

    }

    }