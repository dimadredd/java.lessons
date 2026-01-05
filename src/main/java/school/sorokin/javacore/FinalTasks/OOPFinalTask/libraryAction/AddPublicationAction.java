package school.sorokin.javacore.FinalTasks.OOPFinalTask.libraryAction;

import school.sorokin.javacore.FinalTasks.OOPFinalTask.Book;
import school.sorokin.javacore.FinalTasks.OOPFinalTask.Library;
import school.sorokin.javacore.FinalTasks.OOPFinalTask.Magazine;
import school.sorokin.javacore.FinalTasks.OOPFinalTask.Newspaper;

import java.util.Scanner;

public class AddPublicationAction implements LibraryAction {

    //Поля для доступа к библиотеке и для ввода данных с консоли
    private final Library library;
    private final Scanner scanner;


    public AddPublicationAction(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    //Переопределяем метод LibraryAction, для добавления публикаций
    @Override
    public void execute() {
        System.out.println("Выберите тип публикации:");
        System.out.println("1. Книга");
        System.out.println("2. Журнал");
        System.out.println("3. Газета");
        System.out.print("Ваш выбор: ");

        String choice = scanner.nextLine();
        System.out.println();

        System.out.print("Введите название: ");
        String title = scanner.nextLine();

        System.out.print("Введите автора: ");
        String author = scanner.nextLine();

        System.out.print("Введите год: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        switch (choice) {
            case "1": {
                System.out.print("Введите ISBN: ");
                String isbn = scanner.nextLine();
                Book book = new Book(title, author, year, isbn);
                library.addPublication(book);
                System.out.println("Книга добавлена.\n");
                break;
            }
            case "2": {
                System.out.println("Введите номер выпуска журнала: ");
                int issueNumber = scanner.nextInt();
                scanner.nextLine();
                Magazine magazine = new Magazine(title, author, year, issueNumber);
                library.addPublication(magazine);
                System.out.println("Журнал добавлен.\n");
                break;
            }
            case "3": {
                System.out.print("Введите день публикации (например, Понедельник): ");
                String day = scanner.nextLine();
                Newspaper newspaper = new Newspaper(title, author, year, day);
                library.addPublication(newspaper);
                System.out.println("Газета добавлена.\n");
                break;
            }
            default:
                System.out.println("Неверный тип публикации. Возврат в меню.\n");
        }
    }

}

