package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Load the Person class
            Class<?> clazz = Class.forName("reflection.Person");

            // Inspect constructors
            System.out.println("Constructors:");
            for (var constructor : clazz.getDeclaredConstructors()) {
                System.out.println(constructor);
            }

            // Inspect fields
            System.out.println("\nFields:");
            for (var field : clazz.getDeclaredFields()) {
                System.out.println(field);
            }

            // Modify access level of private field and set its value
            Person person = new Person("John Doe", 30);
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true); // Bypass the private access modifier
            nameField.set(person, "Jane Doe");

            // Accessing private field value after modification
            System.out.println("\nUpdated Name: " + person.getName());

            // Call private method
            Method printDetailsMethod = clazz.getDeclaredMethod("printDetails");
            printDetailsMethod.setAccessible(true);
            printDetailsMethod.invoke(person);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
