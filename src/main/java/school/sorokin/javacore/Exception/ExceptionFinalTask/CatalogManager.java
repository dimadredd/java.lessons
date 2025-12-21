package school.sorokin.javacore.Exception.ExceptionFinalTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogManager {

    private final List<Book> catalog = new ArrayList<>();

    public void addBook(String author, String title, int availableCopies){
        if (author == null || author.trim().isEmpty()){
            throw new IllegalArgumentException("Автор не может быть пустым.");
        }
        if (title == null || title.trim().isBlank()){
            throw new IllegalArgumentException("Название не может быть пустым.");
        }
        if (availableCopies < 0 ){
            throw new IllegalArgumentException("Количество экземпляров не может быть отрицательным.");
        }

        author = author;
        title = title.trim();

        Book bookExist = findByTitle(title);
        if(bookExist != null){
            bookExist.setAvailableCopies(bookExist.getAvailableCopies() + availableCopies);
            return;
        }

        catalog.add(new Book(author,title,availableCopies));
    }

    public void takeBook(String title){
        if (title == null || title.trim().isBlank()){
            throw new IllegalArgumentException("Название не может быть пустым.");
        }

        Book book = requireByTitle(title);

        if (book.getAvailableCopies() <= 0){
            throw new NoAvailableCopiesException("Нет доступных экземпляров книги: " + book.getTitle());
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);

    }

    public void returnBook(String title){
        if (title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Название не может быть пустым.");
        }

        Book book = requireByTitle(title.trim());
        book.setAvailableCopies(book.getAvailableCopies() + 1);


    }

    public List<Book> getAllBooks(){
        return Collections.unmodifiableList(catalog);
    }

    private Book findByTitle(String title){
        for (Book b : catalog){
            if(b.getTitle().equalsIgnoreCase(title)){
                return b;
            }
        }
        throw new ItemNotFoundException("Книга с названием '" + title + "' не найдена.");
    }

    private Book requireByTitle(String title){
        Book b = findByTitle(title);
        if(b == null){
            throw new ItemNotFoundException("Книга: \"" + title + "\" не найдена в каталоге ");
        }
        return b;
    }

    public void printCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("Каталог пуст.\n");
            return;
        }

        for (Book b : catalog) {
            System.out.println("Книга: " + b.getTitle() + " | " + b.getAuthor() + " | копии: " + b.getAvailableCopies());
        }
        System.out.println();
    }

}
