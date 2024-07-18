package fileoperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLine
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("D:\\names.txt"));
        String line = br.readLine();
        while(line != null)
        {
            System.out.println(line+ " "+ line.length());
            line = br.readLine();
        }



    }

}