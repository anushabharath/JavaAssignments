package annotation;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Sample.class;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(LogExecute.class)) {
                    LogExecute logExecute = method.getAnnotation(LogExecute.class);
                    System.out.println("Method: " + method.getName());
                    System.out.println("Log Message: " + logExecute.msg());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

