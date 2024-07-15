package concurrentCollection;

import java.util.concurrent.ConcurrentHashMap;

public class Concurrent
{
    public static void main (String args[])

    {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
        map.put("One",1);
        map.put("Two",2);
        System.out.println("First key Value :" +map.get("One"));

        System.out.println("Second key Value :" +map.get("Two"));
    }
}
