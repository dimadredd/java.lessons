package school.sorokin.javacore.FinalTasks.OOPFinalTask.libraryAction;

import school.sorokin.javacore.FinalTasks.OOPFinalTask.Publication;

public class ShowTotalCountAction implements LibraryAction{

    //Переопределяем метод LibraryAction, который выводит общее количество публикаций.
    @Override
    public void execute() {
        System.out.println("Общее количество публикаций: " + Publication.getPublicationCount());
        System.out.println();
    }
}
