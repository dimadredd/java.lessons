package school.sorokin.javacore.ReflectionAPI.task2;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String printInfo() {
        return "\nName: " + name
                + ", age: " + age;
    }

    private boolean ageControl(int age) {
        if (age >= 18) {
            return true;
        } else return false;
    }
}
