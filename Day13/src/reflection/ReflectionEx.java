package reflection;

import java.lang.reflect.Modifier;

public class ReflectionEx {
    public static void main(String[] args) {
        Apple obj = new Apple();
        Class<?> ob = obj.getClass();
        String st = ob.getName();
        System.out.println("Name of the Class: " + st);

        int modifier = ob.getModifiers();
        String s1 = Modifier.toString(modifier);
        System.out.println("Modifier: " + s1);

        Class<?> sc = ob.getSuperclass();
        System.out.println("Super Class: " + sc.getName());
    }
}

