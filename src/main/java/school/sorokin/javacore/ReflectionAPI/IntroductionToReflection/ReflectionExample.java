package school.sorokin.javacore.ReflectionAPI.IntroductionToReflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
        classAnalyzer(User.class);
        classAnalyzer(Member.class);

    }

    public static void classAnalyzer(Class<?> clazz) {
        System.out.println("Class name: " + clazz.getClass());

//        Список полей
        System.out.println("\nFields:" );
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("-" + field.getName() + " : " + field.getType().getSimpleName());
        }

//        Список методов
        System.out.println("\nMethods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("-" + method.getName());
        }

        System.out.println("\n--------------------------\n");
    }
}
