package school.sorokin.javacore.OOP.OOPFinalTask;

import java.util.Objects;

public abstract class Publication {

    //Инициализируем поля абстракного класса.
    private String title;
    private String author;
    private int year;
    private static int publicationCounter = 0;

    //Инициализируем конструктор и статистический счетчик.
    public Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        publicationCounter++;
    }

    //Инициализируем геттер и сеттер для title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //Инициализируем геттер и сеттер для author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //Инициализируем геттер и сеттер для year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //Инициализируем геттер для counter
    public static int getPublicationCount() {
        return publicationCounter;
    }

    //Абстрактный метод который будут переопределять наследники.
    public abstract String getType();

    //Переопределяем метод toString() для понятного вывода.
    @Override
    public String toString(){
        return "Название: " + title + ".\n Автор: " + author + ".\n Год выпуска: " + year + ".";
    }

    //Переопределяем метод equals() для корректного сравнения объектов
    @Override
    public boolean equals(Object obj){

        //Проверяем, являются ли ссылки на один и тот же объект в памяти
        if(this == obj) return true;

        //Проверяем, что объект не null и что классы совпадают
        if(obj == null || getClass() != obj.getClass()) return false;

        //Приводим объект obj к типу Publication
        Publication pub = (Publication) obj;

        //Сравниваем основные поля объекта: title и author
        return Objects.equals(title, pub.title) && Objects.equals(author, pub.author);
    }

    //Переопределяем метод hashCode() для соблюдения контракта с equals()
    @Override
    public int hashCode(){

        //Формируем хеш-код на основе тех же полей, что используются в equals()
        return Objects.hash(title,author);
    }
}
