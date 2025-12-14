package school.sorokin.javacore.OOP.OOPFinalTask;

import java.util.Objects;

public class Book extends Publication implements Printable{

    //Инициализируем поля класса.
    private String ISBN;

    //Инициализируем конструктор.
    public Book(String title, String author, int year, String ISBN){
        super(title,author,year);
        this.ISBN = ISBN;
    }

    //Инициализируем геттер и сеттер для ISBN
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    //Переопределяем метод toString() для понятного вывода.
    @Override
    public String toString(){
        return super.toString() + "\n ISBN: " + ISBN;
    }

    //Переопределяем метод equals() для корректного сравнения объектов
    @Override
    public boolean equals(Object o){

        //Проверяем, являются ли ссылки на один и тот же объект в памяти
        if(this == o) {
            return true;
        }

        //Проверяем принадлежит объект к типу Book
        if (!(o instanceof Book)) return false;

        //Сравниваем унаследованные поля через equals() предка
        if(!super.equals(o)) return false;

        //Приводим объект o к типу Book
        Book book = (Book) o;

        //Сравниваем уникальное поле ISBN
        return Objects.equals(this.ISBN, book.ISBN);
    }

    //Переопределяем метод hashCode() для соблюдения контракта с equals()
    @Override
    public int hashCode(){

        //Формируем хеш-код на основе тех же полей, что используются в equals()
        return Objects.hash(super.hashCode(), ISBN);
    }

    //Переопределяем метод getType() для типа Книга.
    @Override
    public String getType(){
        return "Книга";
    }

    //Переопределяем метод printDetails() для понятного вывода.
    @Override
    public void printDetails(){
        System.out.println(getType());
        System.out.println();
    }

}
