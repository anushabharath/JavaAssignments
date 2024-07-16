package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionMethodEx {
    public static void main(String[] args) {
        Orange ob = new Orange();
        Class<?> obj = ob.getClass();
        Method[] methods = obj.getDeclaredMethods();

        // get method names and return types
        for (Method method : methods) {
            System.out.println("Method Name: " + method.getName());
            System.out.println("Return Type: " + method.getReturnType());
        }

        int modifier = obj.getModifiers();
        System.out.println("Modifiers: " + Modifier.toString(modifier));
    }
}


