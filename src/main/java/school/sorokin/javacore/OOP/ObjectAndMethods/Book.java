package school.sorokin.javacore.OOP.ObjectAndMethods;
import java.util.Objects;

public class Book {

    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString(){
        return "Название книги: '" + title + "'. Автор:  " + author;
    }

    @Override
    public boolean equals(Object obj){
       if(this == obj) return true;
       if (obj == null || getClass() != obj.getClass()) return false;

       Book book = (Book) obj;

       return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, author);
    }
}

