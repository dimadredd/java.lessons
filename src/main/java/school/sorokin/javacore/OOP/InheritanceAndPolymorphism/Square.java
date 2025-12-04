package school.sorokin.javacore.OOP.InheritanceAndPolymorphism;

public class Square extends Shape{

    private int a = 50;
    private int b = 15;

    @Override
    public void draw(){
        System.out.println("Drawing a square");
    }

    @Override
    public int calculateArea(){
        return a+b;
    }
}
