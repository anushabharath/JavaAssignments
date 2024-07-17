package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonSorter {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 30));
        persons.add(new Person("Bob", 25));
        persons.add(new Person("Charlie", 35));

        // Using lambda expression to implement Comparator
        Collections.sort(persons, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        // Print sorted list
        persons.forEach(System.out::println);
    }
}
