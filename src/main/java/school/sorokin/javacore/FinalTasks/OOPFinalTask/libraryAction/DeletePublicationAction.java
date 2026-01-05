package school.sorokin.javacore.FinalTasks.OOPFinalTask.libraryAction;

import school.sorokin.javacore.FinalTasks.OOPFinalTask.Library;
import school.sorokin.javacore.FinalTasks.OOPFinalTask.Publication;

import java.util.List;
import java.util.Scanner;

public class DeletePublicationAction implements LibraryAction{

    //Поля для доступа к библиотеке и для ввода данных с консоли
    private final Library library;
    private final Scanner scanner;

    //Конструктор, который инициализирует поля library и scanner
    public DeletePublicationAction(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    //Переопределяем метод LibraryAction, для удаления публикаций
    @Override
    public void execute() {

        //Получаем список всех публикаций через метод getPublications()
        List<Publication> list = library.getPublications();

        //Проверяем, пуст ли список
        if (list.isEmpty()) {
            System.out.println("Библиотека пуста, удалять нечего.\n");
            return;
        }

        //Перебираем список через цикл for и выводим все записи с номерами через метод get(i)
        System.out.println("Список публикаций:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ": " + list.get(i));
        }

        //Просим ввести номер для удаления.
        System.out.println("Введите номер публикации для удаления: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        //Проверяем корректность введенного номера
        if (index < 1 || index > list.size()) {
            System.out.println("Некорректный номер.\n");
            return;
        }

        //Получаем индекс от пользователя и удаляем через метод deletePublication()
        Publication pub = list.get(index - 1);
        library.deletePublication(pub);
        System.out.println();
    }

}
