package school.sorokin.javacore.CollectionFramework.EqualsAndHashCodeContract;

public class Product {

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /** Реализуйте equals так, чтобы сравнивались только, например, поле id,
     * игнорируя остальные важные поля (name и price).
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product other = (Product) obj;
        return id == other.id;
    }

    /** Реализуйте hashCode так, чтобы он всегда возвращал одно и то же значение
     * (например, всегда возвращал число 42) или не учитывал все значимые поля объекта.
     */

    @Override
    public int hashCode(){
        return 42;
    }
}
