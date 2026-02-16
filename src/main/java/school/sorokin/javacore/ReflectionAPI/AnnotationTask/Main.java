package school.sorokin.javacore.ReflectionAPI.AnnotationTask;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Class<?> clazz = Service.class;
        Service service = new Service();
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("All methods: ");
        for (Method m : methods) {
            System.out.println("-" + m.getName());

        }

        for (Method m : methods) {
            if (m.isAnnotationPresent(Action.class)) {
                Action annotation = m.getAnnotation(Action.class);
                System.out.println("\nFound annotation method: " + m.getName());
                System.out.println("Annotation description: " + annotation.description());
                m.setAccessible(true);
                m.invoke(service);
            }
        }
    }
}
