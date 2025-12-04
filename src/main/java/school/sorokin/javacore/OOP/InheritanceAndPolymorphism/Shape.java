package school.sorokin.javacore.OOP.InheritanceAndPolymorphism;

public class Shape {

    private int a = 5;
    private int b = 10;

    public void draw(){
        System.out.println("Drawing a generic shape");
    }

    public int calculateArea(){
        return a+b;
    }
}
