package school.sorokin.javacore.CollectionFramework.CollectionFinalTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        System.out.println("ТЕЛЕФОННАЯ КНИГА");
        while (true) {

            System.out.println("\n1. Добавить контакт");
            System.out.println("2. Удалить контакт");
            System.out.println("3. Посмотреть все контакты");
            System.out.println("4. Найти контакт");
            System.out.println("5. Посмотреть контакты по группе");
            System.out.println("0. Выход");
            System.out.print("\nВыберите пункт от 1-5: ");

            String console = sc.nextLine().trim();
            int choice = Integer.parseInt(console);

            try {

                switch (choice){
                case 1:
                    String name = noEmptyLine(sc, "Введите имя: ", "имя не может быть пустым!");
                    String phone = readPhone(sc, phoneBook);
                    String email = readEmail(sc,phoneBook);
                    String group = noEmptyLine(sc, "Введите группу: ", "группа не может быть пустой!");

                    phoneBook.addContact(name, phone, email, group);
                    backToMenu(sc);
                    break;
                case 2:
                    String input = noEmptyLine(sc, "Введите имя: ", "имя не может быть пустым!");
                    phoneBook.deleteContact(input);
                    backToMenu(sc);
                    break;
                case 3:
                    phoneBook.printAllContacts();
                    backToMenu(sc);
                    break;
                case 4:
                    System.out.print("Введите имя контакта: ");
                    String findName = sc.nextLine().trim();
                    phoneBook.findByName(findName);
                    backToMenu(sc);
                    break;
                case 5:
                    System.out.print("Введите название группы: ");
                    String findGroup = sc.nextLine().trim();
                    phoneBook.findByGroup(findGroup);
                    backToMenu(sc);
                    break;
                case 0:
                    System.out.println("Выход из приложения.");
                    sc.close();
                    return;
                }
            }catch (DuplicateException | ContactNotFoundException | IllegalArgumentException e){
                System.out.println("ошибка: " + e.getMessage());
                backToMenu(sc);
            }

        }

    }

    /** Вспомогательные блоки:
     * - noEmptiLine()  не пропускает ввод пустых строк.
     * - readPhone() не пропускает телефон не в формате цифр.
     * - readEmail() не пропускает имеел в непраавильном формате.
     * - backToMenu() возвращает в меню при нажатии "0".
     */
    public static String noEmptyLine(Scanner sc, String message, String errorMessage){
        while (true){
            System.out.print(message);
            String input = sc.nextLine().trim();

            if (input.isBlank()){
                System.out.println("Ошибка: " + errorMessage);
                continue;
            }

            return input;
        }
    }

    public static String readPhone(Scanner sc, PhoneBook phoneBook){
        while (true){
            System.out.print("Введите телефон: ");
            String phone = sc.nextLine().trim();

            try {
                return phoneBook.validPhone(phone);
            }catch (IllegalArgumentException e){
                System.out.println("Ошибка: " + e.getMessage() + " \n");
            }
        }
    }

    public static String readEmail(Scanner sc, PhoneBook phoneBook){
        while (true){
            System.out.print("Введите email: ");
            String email = sc.nextLine().trim();

            try {
                return phoneBook.validEmail(email);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage() + " \n");
            }
        }
    }

    public static void backToMenu(Scanner sc){
        while (true){
            System.out.print("\nДля выхода в меню нажмите 0: ");
            String input = sc.nextLine().trim();

            if (input.isBlank()){
                System.out.println("Ошибка: не может быть пустым!");
            }

            try {
                int choice = Integer.parseInt(input);

                if (choice == 0){
                    return;
                }else {
                    System.out.println("Ошибка: введите число 0!\n");
                }

            }catch (NumberFormatException e){
                System.out.println("Ошибка: введите число 0!\n");
            }
        }
    }
}
