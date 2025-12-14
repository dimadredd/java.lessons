package school.sorokin.javacore.OOP.OOPFinalTask.libraryAction;

import school.sorokin.javacore.OOP.OOPFinalTask.Library;


public class ListPublicationsAction implements LibraryAction {

    // Поле для доступа к библиотеке
    private final Library library;

    // Конструктор, который инициализирует поле library
    public ListPublicationsAction(Library library) {
        this.library = library;
    }

    //Переопределяем метод LibraryAction, для вывода всех публикаций в списке Library()
    @Override
    public void execute() {
        library.listPublications();
        System.out.println();
    }
}

