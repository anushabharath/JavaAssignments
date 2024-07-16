package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericDemo
{
    public static void main(String args[])
    {
        // without generics
        List l1 = new ArrayList<>();
        l1.add("Java");
        l1.add("dhvhds");
      //  l1.add(1234);
        for(Object s:l1)
       {
            System.out.println((String) s);
        }
        
        // with generics
        List<String> list = new ArrayList<>();
        list.add("Ram");
        list.add("dcscgs");
      //  list.add(12333);
        list.add("dshcdsvc");
        
    }
}
