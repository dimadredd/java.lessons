package school.sorokin.javacore.OOP.EncapsulationAndAcsess;

public class Main {
    public static void main(String[] args) {

        Car toyota = new Car();
        toyota.setBrand("Toyota");
        toyota.setModel("Camry");
        toyota.setYear(1881);

        Car bmw = new Car();
        bmw.setBrand("BMW");
        bmw.setModel("X5M");
        bmw.setYear(2019);

        System.out.println(toyota.toString());
        System.out.println(bmw.toString());
    }
}
