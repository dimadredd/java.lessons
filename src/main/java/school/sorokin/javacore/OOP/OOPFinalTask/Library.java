package school.sorokin.javacore.OOP.OOPFinalTask;

import java.util.ArrayList;
import java.util.List;

public class Library {

    //Инициализируем список всех публикаций библиотеки
    private List<Publication> publications;

    //Геттер для получения списка публикаций
    public List<Publication> getPublications() {
        return publications;
    }

    //Метод, который инициализирует список публикаций
    public Library(){
        publications = new ArrayList<>();
    }

    //Метод, который добавляет публикацию в список
    public void addPublication(Publication pub){
        publications.add(pub);
    }

    //метод, который выводит все публикации в списке
    public void listPublications(){
        //Проверяем, пуст ли список. Если пуст — выводим сообщение и выходим из метода
        if(publications.isEmpty()){
            System.out.println("Библиотека пуста.");
            return;
        }

        //Перебираем список с помощью цикла for-each и выводим каждую публикацию в консоль
        for (Publication pub:publications){
            System.out.println(pub);
        }

    }

    //Метод, который ищет публикации по имени автора
    public void searchByAuthor(String author){
        boolean found = false;

        //Перебираем список с помощью цикла for-each и проверяем записи
        for(Publication pub:publications){

            //Сравниваем имя автора без учёта регистра через equalsIgnoreCase()
            if(pub.getAuthor().equalsIgnoreCase(author)){

                //Проверяем, реализует ли объект интерфейс Printable

                Printable printable = (Printable) pub;

                //Выводим подробную информацию о публикации через интерфейс Printable
                printable.printDetails();

                found = true;
            }
        }

        //Если ни одной публикации с заданным автором не найдено — выводим сообщение
        if(!found){
            System.out.println("Публикации автора '" + author + "' не найдены.");
        }
    }

    //Метод который удаляет публикацию
    public void deletePublication(Publication pub){
        if(publications.remove(pub)){
            System.out.println("Публикация удалена.");
        }else{
            System.out.println("Такая публикация не найдена.");
        }
    }
}
