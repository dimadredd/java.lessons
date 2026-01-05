package school.sorokin.javacore.FinalTasks.OOPFinalTask;

import java.util.Objects;

public class Newspaper extends Publication implements Printable{

    //Инициализируем поля класса.
    private String publicationDay;

    //Инициализируем конструктор.
    public Newspaper(String title, String author, int year, String publicationDay){
        super(title,author,year);
        this.publicationDay = publicationDay;
    }

    //Инициализируем геттер и сеттер для publicationDay
    public String getPublicationDay(){
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }

    //Переопределяем метод toString() для понятного вывода.
    @Override
    public String toString(){
        return super.toString() + "\n дата публикации: " + publicationDay;
    }

    //Переопределяем метод equals() для корректного сравнения объектов
    @Override
    public boolean equals(Object o){

        //Проверяем, являются ли ссылки на один и тот же объект в памяти
        if(this == o) return true;

        //Проверяем принадлежит объект к типу Newspaper
        if(!(o instanceof Newspaper)) return false;

        //Сравниваем унаследованные поля через equals() предка
        if(!(super.equals(o))) return false;

        //Приводим объект o к типу Newspaper
        Newspaper newspaper = (Newspaper) o;

        //Сравниваем уникальное поле publicationDay
        return Objects.equals(this.publicationDay, newspaper.publicationDay);
    }

    //Переопределяем метод hashCode() для соблюдения контракта с equals()
    @Override
    public int hashCode(){

        //Формируем хеш-код на основе тех же полей, что используются в equals()
        return Objects.hash(super.hashCode(), publicationDay);
    }

    //Переопределяем метод getType() для типа Газета.
    @Override
    public String getType(){
        return "Газета";
    }

    //Переопределяем метод printDetails() для понятного вывода.
    @Override
    public void printDetails(){
        System.out.println(getType());
        System.out.println("День публикации: " + publicationDay);
        System.out.println();
    }
}
