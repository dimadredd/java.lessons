package school.sorokin.javacore.ReflectionAPI.task2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = Person.class;

        Constructor<?> constructors = clazz.getConstructor(String.class, int.class);
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("Конструктор: " + constructors.getName());

        System.out.println("\nСписок полей: ");
        for (Field f : fields){
            System.out.println(f.getName() + " : " + f.getType());
        }

        System.out.println("\nСписок методов: ");
        for (Method m : methods) {
            System.out.println(m.getName());
        }

//        Создаем объект Person через конструктор
        Object personInstance = constructors.newInstance("Petr", 18);

//        Получаем значение приватного поля (age)
        Field ageField = clazz.getDeclaredField("age");

//        Изменяем приватное значение поля (age)
        ageField.setAccessible(true);
        System.out.println("\nТекущее значение ageField: " + ageField.get(personInstance));

        ageField.set(personInstance, 20);
        System.out.println("Обновленное значение ageField: " + ageField.get(personInstance));

//        Вызов публичного метода printInfo()
        Method printInfoMethod = clazz.getMethod("printInfo");
        System.out.println("\nВызов публичного метода printInfo(): " + printInfoMethod.invoke(personInstance));

//        Вызов приватного метода ageControl()
        Method ageControlMethod = clazz.getDeclaredMethod("ageControl", int.class);
        ageControlMethod.setAccessible(true);

        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println("Проверка возраста " + nameField.get(personInstance) + " на совершеннолетие: "
                + ageControlMethod.invoke(personInstance, ageField.get(personInstance)));
    }
}
