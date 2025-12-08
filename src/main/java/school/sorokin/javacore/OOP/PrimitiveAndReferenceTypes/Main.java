package school.sorokin.javacore.OOP.PrimitiveAndReferenceTypes;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        double b = 10.34;
        boolean c = true;

        System.out.println(a);
        changePrimitive(a);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        Person p = new Person("Alex", 20);
        System.out.println(p);
        changeObject(p);
        System.out.println(p);

        p = null;
        System.gc();

    }

    static void changePrimitive(int value){
        value = 100;
    }

    static void changeObject(Person person){
        person.name = "Bob";
        person.age = 30;
    }
}
