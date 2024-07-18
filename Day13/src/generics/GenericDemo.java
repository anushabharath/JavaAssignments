package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {
    public static void main(String args[]) {
        // without generic
        List l1 = new ArrayList();
        l1.add("Java");
        l1.add("dhvhds");
        // l1.add(1234); // This line is commented out to prevent ClassCastException

        for (Object s : l1) {
            System.out.println((String) s); // This cast will work as long as all elements are strings
        }

        // with generic
        List<String> list = new ArrayList<>();
        list.add("Ram");
        list.add("dcscgs");
        // list.add(12333); // This line is commented out because it would cause a compile-time error
        list.add("dshcdsvc");

        // Enhanced for loop to print the elements of the generic list
        for (String s : list) {
            System.out.println(s);
        }
    }
}
