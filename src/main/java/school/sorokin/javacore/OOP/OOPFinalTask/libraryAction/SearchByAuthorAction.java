package school.sorokin.javacore.OOP.OOPFinalTask.libraryAction;

import school.sorokin.javacore.OOP.OOPFinalTask.Library;

import java.util.Scanner;

public class SearchByAuthorAction implements LibraryAction{

    //Ссылки на библиотеку и сканер для работы с консолью
    private final Library library;
    private final Scanner scanner;

    //Конструктор, который инициализирует поля library и scanner
    public SearchByAuthorAction(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    //Переопределяем метод LibraryAction, для поиска публикаций по searchByAuthor() из Library
    @Override
    public void execute() {
        System.out.print("Введите имя автора для поиска: ");
        String author = scanner.nextLine();
        System.out.println();
        library.searchByAuthor(author);
        System.out.println();
    }
}
