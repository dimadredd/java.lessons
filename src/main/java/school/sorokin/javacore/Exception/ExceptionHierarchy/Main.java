package school.sorokin.javacore.Exception.ExceptionHierarchy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        fileReaderExample(); //checked
        arrayIndexExample(); //unchecked
    }

    // checked exception: IOException (обязана быть обработана/объявлена)
    public static void fileReaderExample(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            String line = reader.readLine();
            System.out.println("Прочитали первую строку: " + line);
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла " + e.getClass() + e.getMessage());
        }
    }

    // unchecked exception: ArrayIndexOutOfBoundsException (компилятор не требует обработки)
    public static void arrayIndexExample(){
        try {
            int[] arr = new int[2];
            arr[3] = 10;
            int result = arr[1];
            System.out.println("Результат: " + result);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
