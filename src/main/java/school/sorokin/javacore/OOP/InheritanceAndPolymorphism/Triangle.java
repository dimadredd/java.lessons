package school.sorokin.javacore.OOP.InheritanceAndPolymorphism;

public class Triangle extends Shape{

    private int a = 2;
    private int b = 1;

    @Override
    public void draw(){
        System.out.println("Drawing a triangle");
    }

    @Override
    public int calculateArea(){
        return a+b;
    }
}
