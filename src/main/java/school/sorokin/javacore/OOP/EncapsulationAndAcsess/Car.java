package school.sorokin.javacore.OOP.EncapsulationAndAcsess;

public class Car {

    private String brand;
    private String model;
    private int year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        if(year < 1886){
            System.out.println("Ошибка! Первая машина была создана в 1886 году.");
            return;
        }
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString(){
        return "1. Car: " + getBrand() + ". Model: " + getModel() + ". Year: " + getYear();
    }


}
