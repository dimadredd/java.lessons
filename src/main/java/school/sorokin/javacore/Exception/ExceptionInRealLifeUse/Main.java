package school.sorokin.javacore.Exception.ExceptionInRealLifeUse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner console = new Scanner(System.in)) {

            System.out.print("Введите путь к файлу: ");
            String filepath = console.nextLine().trim();

           try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {

               String fileData = reader.readLine();

               if (fileData == null || fileData.trim().isEmpty()){
                   System.out.println("Ошибка: файл пуст.");
               }else {
                   String[] words = fileData.trim().split("\\s+");
                   System.out.println("Итоговое число слов в строке: " + words.length);
               }
           }

        } catch (FileNotFoundException e){
            System.out.println("Ошибка: файла нет");
        } catch (IOException e){
            System.out.println("Ошибка: ошибка чтения");
        } catch (InputMismatchException e){
            System.out.println("Ошибка: введите путь к файлу.");
        }finally {
            System.out.println("Спасибо за использование!");
        }
    }
}
