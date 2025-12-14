package school.sorokin.javacore.OOP.OOPFinalTask;

import school.sorokin.javacore.OOP.OOPFinalTask.libraryAction.*;

import java.util.Scanner;

public class LibraryConsole {

    //Ссылки на библиотеку и сканер для работы с консолью
    private final Library library;
    private final Scanner scanner;

    //Конструктор, который инициализирует поля library и scanner
    public LibraryConsole(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    //Метод который выводит меню
    public void printMenu() {
        System.out.println("Библиотека.");
        System.out.println("1. Добавить новую публикацию");
        System.out.println("2. Вывести список всех публикаций");
        System.out.println("3. Поиск публикации по автору");
        System.out.println("4. Вывести общее количество публикаций");
        System.out.println("5. Удалить публикацию");
        System.out.println("0. Выход");
        System.out.print("Выберите пункт меню: ");
    }

    //Метод, который обрабатывает выбор пользователя в меню
    public void menuChoice() {

        while (true) {
            String menuChoice = scanner.nextLine();
            System.out.println();

            switch (menuChoice) {
                case "1":
                    //Действие: Добавить новую публикацию
                    new AddPublicationAction(library, scanner).execute();
                    menuReturn(scanner);
                    printMenu();
                    break;
                case "2":
                    //Действие: Вывести список всех публикаций
                    new ListPublicationsAction(library).execute();
                    menuReturn(scanner);
                    printMenu();
                    break;
                case "3":
                    //Действие: Поиск публикации по автору
                    new SearchByAuthorAction(library, scanner).execute();
                    menuReturn(scanner);
                    printMenu();
                    break;
                case "4":
                    //Действие: Вывести общее количество публикаций
                    new ShowTotalCountAction().execute();
                    menuReturn(scanner);
                    printMenu();
                    break;
                case "5":
                    //Действие: Удалить публикацию
                    new DeletePublicationAction(library,scanner).execute();
                    menuReturn(scanner);
                    printMenu();
                case "0":
                    System.out.println("ВЫХОД ИЗ ПРОГРАММЫ.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте ещё раз.\n");
            }
        }
    }

    //Метод, который ожидает нажатия 0 для возврата в главное меню
    public static void menuReturn(Scanner console) {

        String input;

        do {
            System.out.println("Нажмите 0, чтобы вернуться в меню:");
            input = console.nextLine().trim();

            if (!"0".equals(input)) {
                System.out.println("Ошибка: нужно нажать именно 0.\n");
            }
        } while (!"0".equals(input));
    }

}

