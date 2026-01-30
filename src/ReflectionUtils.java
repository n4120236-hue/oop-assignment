package utils;
import java.lang.reflect.*;

public class ReflectionUtils {
    public static void printClassDetails(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println("Reflection - Class: " + clazz.getName());
        System.out.println("Fields count: " + clazz.getDeclaredFields().length);
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println("Method: " + m.getName());
        }
    }
}