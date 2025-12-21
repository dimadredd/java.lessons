package school.sorokin.javacore.Exception.ExceptionFinalTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CatalogManager catalog = new CatalogManager();

        Scanner sc = new Scanner(System.in);

        System.out.println("ДОБРО ПОЖАЛОВАТЬ В БИБЛИОТЕКУ \n");

        while(true) {

            System.out.println("1. Вывести каталог.");
            System.out.println("2. Добавить книгу.");
            System.out.println("3. Выдать книгу.");
            System.out.println("4. Вернуть книгу.");
            System.out.println("5. Выйти из приложения.\n");


            System.out.print("Выберете пункт от 1 до 5: ");
            String input = sc.nextLine().trim();
            System.out.println();

            if(input.isEmpty()){
                System.out.println("ошибка: ввод не может быть пустым. \n");
                continue;
            }

            try {

                int choice = Integer.parseInt(input);

                if(choice < 1 || choice > 5){
                    System.out.println("ошибка: выберите между 1 - 5. \n");
                    continue;
                }

                switch (choice){
                    case 1:
                        catalog.printCatalog();
                        returnToMenu(sc);
                        break;
                    case 2:
                        System.out.println("ДОБАВЛЕНИЕ КНИГ");

                        String author = readNonEmptyLine(sc, "Введите автора: ");
                        String title  = readNonEmptyLine(sc, "Введите название: ");
                        int copies    = readNonNegativeInt(sc, "Введите количество копий: ");

                        catalog.addBook(author, title, copies);
                        System.out.println("Книга добавлена!\n");
                        returnToMenu(sc);
                        break;

                    case 3:
                        System.out.println("ВЫДАЧА КНИГИ");

                        try {
                            String titleToTake = readNonEmptyLine(sc, "Введите название книги: ");
                            catalog.takeBook(titleToTake);
                            System.out.println("Книга выдана.\n");
                        } catch (ItemNotFoundException | NoAvailableCopiesException e) {
                            System.out.println("Ошибка: " + e.getMessage() + "\n");
                        }
                        returnToMenu(sc);
                        break;

                    case 4:
                        System.out.println("ВОЗВРАТ КНИГИ");

                        try{
                            String titleToReturn = readNonEmptyLine(sc,"Введите название книги: ");
                            catalog.returnBook(titleToReturn);
                            System.out.println("Книга возвращена.\n");
                        }catch (ItemNotFoundException e){
                            System.out.println("Ошибка: " + e.getMessage() + "\n");
                        }
                        returnToMenu(sc);
                        break;
                    case 5:
                        System.out.println("Выход из приложения.");
                        sc.close();
                        return;
                }

            } catch (NumberFormatException e) {
                System.out.println("ошибка: введите целое число. \n");
            }
        }
    }


    /**
     *Методы хэлперы возврат в меню + проверка пустых строк при вводе + проверка int
     */

    static void returnToMenu(Scanner scanner){

       while (true){
           System.out.println("Для возврата в меню нажмите 0: ");
           String input = scanner.nextLine().trim();

           if (input.isEmpty()){
               System.out.println("Ошибка: ввод не может быть пустым.");
           }

           try {
               int choice = Integer.parseInt(input);

               if( choice == 0){
                   return;
               } else{
                   System.out.println("Ошибка: нажмите 0 для возврата.");
               }
           } catch (NumberFormatException e){
               System.out.println("Ошибка: введите число 0.");
           }
       }
    }

    public static String readNonEmptyLine(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Ошибка: поле не может быть пустым. \n");
                continue;
            }

            return input;
        }
    }

    public static int readNonNegativeInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Ошибка: поле не может быть пустым. \n");
                continue;
            }

            try {
                int value = Integer.parseInt(input);
                if (value < 0) {
                    System.out.println("Ошибка: число не может быть отрицательным. \n");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число. \n");
            }
        }
    }
}
