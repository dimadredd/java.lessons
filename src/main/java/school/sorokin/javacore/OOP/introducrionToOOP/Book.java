package school.sorokin.javacore.OOP.introducrionToOOP;

public class Book {
    String title;
    String author;
    int pages;

    public void read(){
        System.out.println("Вы читаете книгу '" + title + "' авторства " + author);
    }
}
