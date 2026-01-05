package school.sorokin.javacore.FinalTasks.OOPFinalTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Создаём объект библиотеки, сканер для ввода и консольный интерфейс
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        LibraryConsole lc = new LibraryConsole(library, scanner);

        //Выводим главное меню в консоль
        lc.printMenu();

        //Запускаем обработку выбора пользователя
        lc.menuChoice();

    }
}
