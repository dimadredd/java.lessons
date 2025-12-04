package school.sorokin.javacore.OOP.InheritanceAndPolymorphism;

public class Circle extends Shape {

    private int a = 20;
    private int b = 5;

    @Override
    public void draw(){
        System.out.println("Drawing a circle");
    }

    @Override
    public int calculateArea(){
        return a+b;
    }
}

