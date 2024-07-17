package assignment;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesExample {

    public static void operateOnPerson(Person person,
                                       Predicate<Person> predicate,
                                       Function<Person, String> function,
                                       Consumer<Person> consumer,
                                       Supplier<Person> supplier) {
        // Using Predicate to test the person
        if (predicate.test(person)) {
            System.out.println("Predicate test passed for: " + person);
        } else {
            System.out.println("Predicate test failed for: " + person);
        }

        // Using Function to apply a function on the person and get a result
        String result = function.apply(person);
        System.out.println("Function result: " + result);

        // Using Consumer to perform an action on the person
        consumer.accept(person);
        System.out.println("Consumer applied: " + person);

        // Using Supplier to get a new Person object
        Person newPerson = supplier.get();
        System.out.println("Supplier provided: " + newPerson);
    }

    public static void main(String[] args) {
        Person person = new Person("Alice", 30);

        // Define Predicate, Function, Consumer, and Supplier
        Predicate<Person> isAdult = p -> p.getAge() >= 18;
        Function<Person, String> getName = Person::getName;
        Consumer<Person> increaseAge = p -> p.setAge(p.getAge() + 1);
        Supplier<Person> newPersonSupplier = () -> new Person("Bob", 25);

        // Operate on Person using the defined functional interfaces
        operateOnPerson(person, isAdult, getName, increaseAge, newPersonSupplier);
    }
}