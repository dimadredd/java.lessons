package school.sorokin.javacore.FinalTasks.OOPFinalTask;

import java.util.Objects;

public class Magazine extends Publication implements Printable{

    //Инициализируем поля класса.
    private int issueNumber;

    //Инициализируем конструктор.
    public Magazine(String title, String author, int year, int issueNumber){
        super(title,author,year);
        this.issueNumber = issueNumber;
    }

    //Инициализируем геттер и сеттер для issueNumber
    public int getIssueNumber(){
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    //Переопределяем метод toString() для понятного вывода.
    @Override
    public String toString(){
        return super.toString() + "\n Номер выпуска: " + issueNumber;
    }

    //Переопределяем метод equals() для корректного сравнения объектов
    @Override
    public boolean equals(Object o){

        //Проверяем, являются ли ссылки на один и тот же объект в памяти
        if(this == o) return true;

        //Проверяем принадлежит объект к типу Magazine
        if(!(o instanceof Magazine)) return false;

        //Сравниваем унаследованные поля через equals() предка
        if(!(super.equals(o))) return false;

        //Приводим объект o к типу Magazine
        Magazine magazine = (Magazine) o;

        //Сравниваем уникальное поле issueNumber
        return Objects.equals(this.issueNumber, magazine.issueNumber);
    }

    //Переопределяем метод hashCode() для соблюдения контракта с equals()
    @Override
    public int hashCode(){

        //Формируем хеш-код на основе тех же полей, что используются в equals()
        return Objects.hash(super.hashCode(), issueNumber);
    }

    //Переопределяем метод getType() для типа Журнал.
    @Override
    public String getType(){
        return "Журнал";
    }

    //Переопределяем метод printDetails() для понятного вывода.
    @Override
    public void printDetails(){
        System.out.println(getType());
        System.out.println("Номер выпуска: " + issueNumber);
        System.out.println();
    }
}
