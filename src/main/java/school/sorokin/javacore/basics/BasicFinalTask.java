package school.sorokin.javacore.basics;

import java.util.Scanner;

public class BasicFinalTask {

    public static void waitForZero(Scanner console) {

        String input;

        do {
            System.out.println("Нажмите 0, чтобы вернуться в меню:");
            input = console.nextLine().trim();

            if (!"0".equals(input)) {
                System.out.println("Ошибка: нужно нажать именно 0.\n");
            }
        } while (!"0".equals(input));
    }


    public static void main(String[] args) {

        //Инициализируем сканер и создаем два массива имя и телефон.
        Scanner console = new Scanner(System.in);
        System.out.println("Решите, какой будет максимальный размер контактов (например, 100 контактов)");
        int size = console.nextInt();

        String[] names = new String[size];
        String[] phones = new String[size];
        String menu;
        int choice;
        boolean checkFlag = false;


        //Делаем цикличное меню, где пользователь делает выбор.
        while(true) {
            System.out.println("ТЕЛЕФОННАЯ КНИГА СОЗДАНА");
            System.out.println();
            System.out.println("1.Добавление нового контакта.");
            System.out.println("2.Просмотр всех контактов.");
            System.out.println("3.Поиск контакта по имени.");
            System.out.println("4.Удаление контакта");
            System.out.println("0.Выход из программы:");
            System.out.println();
            System.out.println("Введите число:");
            System.out.println();

            //Проверяем корретность выбора
            while(true){
                System.out.println("Введите число от 0 до 4");
                choice = console.nextInt();
                console.nextLine();
                if(choice >= 0 && choice <= 4){
                    break;
                }
                System.out.println("Ошибка: Число должно быть от 0 до 4.");

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
                    System.out.println("ДОБАВЛЕНИЕ НОВОГО КОНТАКТА:\n");
                    String name;
                    String phone;

                    while(true) {
                        System.out.println("Введите имя: ");
                        name = console.nextLine().trim();

                        if(!name.isEmpty()){
                            break;
                        }

                        System.out.println("Ошибка: имя не может быть пустым. \n");

                    }


                    while(true) {
                        System.out.println("Введите телефон: ");
                        phone = console.nextLine().trim();

                        if(phone.isEmpty()){
                            System.out.println("Ошибка: телефон не может быть пустым. \n");
                            continue;
                        }

                        if(phone.matches("^\\+?\\d{7,15}$")){
                            break;
                        }else{
                            System.out.println("Ошибка: телефон должен содержать только цифры (можно через + в начале, длинна 7-15 символов).");
                        }
                    }




                    for (int i = 0; i < names.length; i++) {
                        if (names[i] == null) {
                            names[i] = name;
                            phones[i] = phone;
                            System.out.println("Контакт записан!");
                            break;
                        }
                    }
                    System.out.println();
                    waitForZero(console);
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
                    waitForZero(console);
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
                        waitForZero(console);
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

                    waitForZero(console);
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
                       waitForZero(console);
                        break;
                    }

                    //Программа удаления: инициализируем флаг для проверки -> просим ввести имя ->
                    // перебираем запись в массиве с проверкой содержания текста ->
                    // если нашли удаляем запись, если нет - выводим "Нет контакта с таким именем." -> выходим в главное меню.
                    System.out.println("Введите имя контакта: ");
                    String deleteContact = console.nextLine().trim();
                    System.out.println();

                    checkFlag = false;

                    for(int i = 0; i < names.length; i++){
                        if(names[i] != null && names[i].equalsIgnoreCase(deleteContact)){
                            //Смещаем элементы влево
                            for (int j = i; j< names.length - 1; j++){
                                names[j] = names[j + 1];
                                phones[j] = phones[j +1];
                            }

                            //Чистим последние элементы
                            names[names.length - 1] = null;
                            phones[phones.length - 1] = null;

                            checkFlag = true;
                            System.out.println("Контакт удален.");
                            break;
                        }
                    }

                    if(!checkFlag){
                        System.out.println("Нет контакта с таким именем.");
                    }
                    System.out.println();

                    waitForZero(console);
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
