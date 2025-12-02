package school.sorokin.javacore.basics;

import java.util.Scanner;

public class BasicFinalTask {
    public static void main(String[] args) {

        //Инициализируем сканер и создаем два массива имя и телефон.
        Scanner console = new Scanner(System.in);
        String[] names = new String[2];
        String[] phones = new String[2];
        String menu;
        boolean checkFlag = false;


        //Делаем цикличное меню, где пользователь делает выбор.
        while(true) {
            System.out.println("ТЕЛЕФОННАЯ КНИГА");
            System.out.println();
            System.out.println("1.Добавление нового контакта.");
            System.out.println("2.Просмотр всех контактов.");
            System.out.println("3.Поиск контакта по имени.");
            System.out.println("4.Удаление контакта");
            System.out.println("0.Выход из программы:");
            System.out.println();
            System.out.println("Введите число:");
            System.out.println();

            int choice = console.nextInt();
            console.nextLine();


            //Проверяем корретность выбора
            while(choice < 0 || choice > 4 ){
                System.out.println("Не корректный выбор. Попробуйте еще раз: ");
                System.out.println("1.Добавление нового контакта.");
                System.out.println("2.Просмотр всех контактов.");
                System.out.println("3.Поиск контакта по имени.");
                System.out.println("4.Удаление контакта");
                System.out.println("0.Выход из программы:");
                System.out.println();

                choice = console.nextInt();
                console.nextLine();
                System.out.println();

            }

            //Собираем меню.
            switch (choice){
                //Пользователь выбрал "ДОБАВЛЕНИЕ НОВОГО КОНТАКТА:"
                case 1:

                    //проверяем есть ли место в массиве, если нету выводим "Нету свободного места, удалите любой контакт." и выходим в основное меню.
                    checkFlag = false;
                    for(int i = 0; i < names.length; i++){
                        if(names[i] == null){
                            checkFlag = true;
                            break;
                        }
                    }

                    if (!checkFlag) {
                        System.out.println("Нету свободного места, удалите любой контакт.");
                        break;
                    }

                    //Если свободное место есть - создаем новый контакт.
                    System.out.println("ДОБАВЛЕНИЕ НОВОГО КОНТАКТА:");
                    System.out.println();

                    System.out.println("Введите имя: ");
                    String name = console.nextLine();
                    System.out.println();

                    System.out.println("Введите телефон: ");
                    String phone = console.nextLine();
                    System.out.println();


                    for (int i = 0; i < names.length; i++) {
                        if (names[i] == null) {
                            names[i] = name;
                            phones[i] = phone;
                            System.out.println("Контакт записан!");
                            break;
                        }
                    }

                    System.out.println();
                    System.out.println("Нажмите 0, чтобы вернуться в меню.");

                    do{
                        menu = console.nextLine();
                        if(!menu.equals("0")){
                        System.out.println("Неизвестная цифра, попробуйте еще раз");
                        System.out.println("Нажмите 0, чтобы вернуться в меню.");
                        }
                    } while(!menu.equals("0"));
                    break;

                //Пользовватель выбрал "СПИСОК ВСЕХ КОНТАКТОВ".
                case 2:
                    //проверяем есть ли запись в массиве, если есть - выводим список, если нету выводим "Нет контактов в записной книге." и выходим в основное меню.
                    System.out.println("СПИСОК ВСЕХ КОНТАКТОВ");
                    System.out.println();

                    checkFlag = false;
                    for(int i = 0; i < names.length; i++){
                        if(names[i] != null){
                            System.out.println((i+1) + "." + names[i] + " - " + phones[i] + ".");
                            checkFlag = true;
                        }
                    }

                    if(!checkFlag){
                        System.out.println("Нет контактов в записной книге.");
                    }

                    System.out.println();
                    System.out.println("Нажмите 0, чтобы вернуться в меню.");
                    do{
                        menu = console.nextLine();
                        if(!menu.equals("0")){
                            System.out.println("Неизвестная цифра, попробуйте еще раз");
                            System.out.println("Нажмите 0, чтобы вернуться в меню.");
                        }
                    } while(!menu.equals("0"));
                    break;

                //Пользовватель выбрал "ПОИСК КОНТАКТА ПО ИМЕНИ".
                case 3:
                    //Инициализируем флаг и проверяем есть ли запись в массиве, если есть - запускаем программу поиска, если нет - выводит "Нет контактов для поиска.", выходим в главное меню.
                    System.out.println("ПОИСК КОНТАКТА ПО ИМЕНИ");
                    System.out.println();

                    checkFlag = false;
                    for(String n : names){
                        if(n != null){
                            checkFlag = true;
                            break;
                        }
                    }

                    if(!checkFlag){
                        System.out.println("Нет контактов для поиска.");
                        System.out.println();
                        System.out.println("Нажмите 0, чтобы вернуться в меню.");
                        do{
                            menu = console.nextLine();
                            if(!menu.equals("0")){
                                System.out.println("Неизвестная цифра, попробуйте еще раз");
                                System.out.println("Нажмите 0, чтобы вернуться в меню.");
                            }
                        } while(!menu.equals("0"));
                        break;
                    }

                    //Программа поиска: инициализируем флаг для проверки -> просим ввести имя ->
                    // перебираем запись в массиве, проверяем схожесть текста ->
                    // если нашли выводим в консоль имя и телефон, если нет - выводим "Нет контактов с таким именем." -> выходим в главное меню.
                    System.out.println("Напишите имя контакта: ");
                    System.out.println();
                    String contactName = console.nextLine();

                    checkFlag = false;
                    for(int i = 0; i < names.length; i++){
                        if(names[i] != null && names[i].equalsIgnoreCase(contactName)){
                            System.out.println("КОНТАКТ НАЙДЕН");
                            System.out.println();
                            System.out.println("Имя: " + names[i]);
                            System.out.println("Телефон: " + phones[i]);
                            checkFlag = true;
                        }
                    }


                    if(!checkFlag){
                        System.out.println("Нет контактов с таким именем.");
                    }
                    System.out.println();

                    System.out.println("Нажмите 0, чтобы вернуться в меню.");
                    do{
                        menu = console.nextLine();
                        if(!menu.equals("0")){
                            System.out.println("Неизвестная цифра, попробуйте еще раз");
                            System.out.println("Нажмите 0, чтобы вернуться в меню.");
                        }
                    } while(!menu.equals("0"));
                    break;

                //Пользовватель выбрал "УДАЛЕНИЕ КОНТАКТА".
                case 4:
                    //Инициализируем флаг и проверяем есть ли запись в массиве, если да - запускаем программу удаления, если нет - выводит "Нет контактов для удаления.", выходим в главное меню.
                    System.out.println("УДАЛЕНИЕ КОНТАКТА");
                    System.out.println();
                    checkFlag = false;

                    for(String n : names){
                        if(n != null){
                            checkFlag = true;
                            break;
                        }
                    }

                    if(!checkFlag){
                        System.out.println("Нет контактов для удаления.");
                        System.out.println();
                        System.out.println("Нажмите 0, чтобы вернуться в меню.");
                        do{
                            menu = console.nextLine();
                            if(!menu.equals("0")){
                                System.out.println("Неизвестная цифра, попробуйте еще раз");
                                System.out.println("Нажмите 0, чтобы вернуться в меню.");
                            }
                        } while(!menu.equals("0"));
                        break;
                    }

                    //Программа удаления: инициализируем флаг для проверки -> просим ввести имя ->
                    // перебираем запись в массиве с проверкой содержания текста ->
                    // если нашли удаляем запись, если нет - выводим "Нет контакта с таким именем." -> выходим в главное меню.
                    System.out.println("Введите имя контакта: ");
                    String deleteContact = console.nextLine();
                    System.out.println();

                    checkFlag = false;
                    for(int i = 0; i < names.length; i++){
                        if(names[i] != null && names[i].contains(deleteContact)){
                            names[i] = null;
                            phones[i] = null;
                            checkFlag = true;
                            System.out.println("Контакт удален.");
                            break;
                        }
                    }

                    if(!checkFlag){
                        System.out.println("Нет контакта с таким именем.");
                    }
                    System.out.println();

                    System.out.println("Нажмите 0, чтобы вернуться в меню.");
                    do{
                        menu = console.nextLine();
                        if(!menu.equals("0")){
                            System.out.println("Неизвестная цифра, попробуйте еще раз");
                            System.out.println("Нажмите 0, чтобы вернуться в меню.");
                        }
                    } while(!menu.equals("0"));
                    break;


                //Пользовватель выбрал "ВЫХОД ИЗ ПРОГРАММЫ."
                case 0:
                    //Завершаем работу цикла программы.

                    System.out.println("ВЫХОД ИЗ ПРОГРАММЫ.");
                    return;
            }

        }
    }
}
