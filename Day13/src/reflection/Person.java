package reflection;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void printDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
