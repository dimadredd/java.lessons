package school.sorokin.javacore.OOP.ObjectAndMethods;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Война и мир", "Лев Толстой");
        Book book2 = new Book("Преступление и наказание", "Фёдор Достоевский");
        Book book3 = new Book("Война и мир", "Лев Толстой");

        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book1.equals(book2));
        System.out.println(book1.equals(book3));
        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());
        System.out.println(book3.hashCode());
    }
}
