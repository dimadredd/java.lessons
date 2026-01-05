package school.sorokin.javacore.FinalTasks.CollectionFinalTask;

import java.util.*;

public class PhoneBook {

    private final List<Contact> phoneBookList = new ArrayList<>();
    private final Set<Contact> phoneBookSet = new HashSet<>();
    private final Map<String, List<Contact>> groupMap = new HashMap<>();

    /** Блок логики "Добавить контакт"
     * +вспомогательный блок isNotEmpty(): проверяет пустоту
     * +вспомогательный блок validPhone(): проверяет формат записи в телефон
     * +вспомогательный блок validEmail(): проверяет формат записи email
     */
    public void addContact(String name, String phone, String email, String group){
        name = isNotEmpty(name, "Имя");
        phone = validPhone(phone);
        email = isNotEmpty(email, "e-mail");
        group = isNotEmpty(group, "группа");

        Contact contact = new Contact(name,phone,email,group);

        if (!phoneBookSet.add(contact)){
            throw new DuplicateException("Контакт уже существует (дубликат по name+phone): " + name + ", " + phone);
        }
        phoneBookList.add(contact);

        List<Contact> groupList = groupMap.get(group);
        if (groupList == null){
            groupList = new ArrayList<>();
            groupMap.put(group, groupList);
        }
        groupList.add(contact);

        System.out.println("\nКонтакт добавлен: " + contact);

    }
    private String isNotEmpty(String s, String field){
        if (s == null || s.trim().isEmpty()){
            throw new IllegalArgumentException("Ошибка: " + field + " не иожет быть пустым!");
        }
        return s.trim();
    }

    public String validPhone(String phone){

        phone = isNotEmpty(phone, "Телефон");

        for (char c : phone.toCharArray()){
            if (!Character.isDigit(c)){
                throw new IllegalArgumentException("Ошибка: телефон должен содержать только цифры!");
            }
        }
        return phone;

    }

    public String validEmail(String email) {
        email = isNotEmpty(email, "E-mail");

        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Ошибка: e-mail должен содержать формат имя@домен!");
        }

        return email;
    }

    // Блок логики "Удаление контактов"
    public void deleteContact(String name){
        name = isNotEmpty(name, "Имя");

        Contact contactToRemove = null;

        //Удаляем из List и запоминаем объект
        for (Iterator<Contact> it = phoneBookList.iterator(); it.hasNext();){
            Contact contact = it.next();
            if (contact.getName().equalsIgnoreCase(name)){
                contactToRemove = contact;
                it.remove();
                break;
            }
        }

        if (contactToRemove == null){
            throw new ContactNotFoundException("Контакт не найден: " + name);
        }

        //Удаляем из Set
        phoneBookSet.remove(contactToRemove);

        //Удаляем из Map группы
        List<Contact> groupList = groupMap.get(contactToRemove.getGroup());
        if (groupList != null){
            groupList.remove(contactToRemove);
            if (groupList.isEmpty()){
                groupMap.remove(contactToRemove.getGroup());
            }
        }

        System.out.println("Контакт удалён: " + contactToRemove);
    }

    //Блок логики "Вывод всех контактов"
    public void printAllContacts(){
        if (phoneBookList.isEmpty()){
            System.out.println("Телефонная книга пуста.");
            return;
        }

        System.out.println("Все контакты: \n");
        for (Iterator<Contact> it = phoneBookList.iterator(); it.hasNext();){
            System.out.println(it.next());
        }
    }

    //Блок логики "Найти контакт"
    public void findByName(String name){
        name = isNotEmpty(name, "Имя");

        boolean found = false;
        for (Iterator<Contact> it = phoneBookList.iterator(); it.hasNext();){
            Contact contact = it.next();
            if (contact.getName().equalsIgnoreCase(name)){
                System.out.println(contact);
                found = true;
            }
        }
        if (!found){
            throw new ContactNotFoundException("Контакт с именем '" + name + "' не найден.");
        }
    }

    //Блок логики "Найти по группе"
    public void findByGroup(String group){
        group = isNotEmpty(group, "Группа");

        List<Contact> contacts = groupMap.get(group);
        if (contacts == null || contacts.isEmpty()){
            throw new ContactNotFoundException("В группе \"" + group + "\" нет контактов.");
        }

        System.out.println("--- Контакты в группе \"" + group + "\": ---");
        for (Iterator<Contact> it = contacts.iterator(); it.hasNext();){
            System.out.println(it.next());
        }
    }
}
