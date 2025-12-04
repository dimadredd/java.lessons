package school.sorokin.javacore.OOP.InheritanceAndPolymorphism;

public class Canvas {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(), new Square(), new Triangle() };

        for(Shape s : shapes){
            s.draw();
            System.out.println(s.calculateArea());
        }
    }
}
