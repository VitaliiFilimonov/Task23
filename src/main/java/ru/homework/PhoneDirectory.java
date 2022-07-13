package ru.homework;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhoneDirectory {
    private static final Logger LOGGER = LogManager.getLogger(PhoneDirectory.class);
    Hashtable<String, String> listOfNumber = new Hashtable<String, String>();
    Enumeration allPhones;
    Scanner terminal = new Scanner(System.in);


    public void addPhoneNumberAndName() { //добавить номер и имя
        String phoneNumber = enterPhoneNumber();
        while(listOfNumber.containsKey(phoneNumber)){
            System.out.println("Запись уже создана! Повторите ввод номера: ");
            phoneNumber = enterPhoneNumber();
        }
        String name = enterName();
        listOfNumber.put(phoneNumber, name);
        //System.out.println("Запись добавлена! ");
        LOGGER.info("Запись добавлена!");
    }

    public void findPhoneNumber() { // найти по номеру
        String phoneNumber = enterPhoneNumber();
        if (listOfNumber.containsKey(phoneNumber)){
            System.out.println("Найденное поле \n" + " Имя: " + listOfNumber.get(phoneNumber)
                    + ", Номер телефона: " + phoneNumber);
        }else{
            System.out.println("Поле не найдено!");
        }
    }

    public void delete() { //удаление
        String phoneNumber = enterPhoneNumber();
        if(!listOfNumber.isEmpty()){
            listOfNumber.remove(phoneNumber);
            //System.out.println("Запись удалена! ");
            LOGGER.info("Запись удалена!");
        }else{
            System.out.println("Таблица пуста! ");
        }
    }

    public void getListOfNumber() { // вывод списка
        allPhones = listOfNumber.keys();
        while (allPhones.hasMoreElements()) {
            String str = (String)allPhones.nextElement();
            System.out.println("Имя: " + listOfNumber.get(str) + ", Номер телефона: "
                    + str);
        }
    }

    public boolean validationPhoneNumber(String phoneNumber) { //проверка телефона
        return Pattern.matches("\\d{2}-\\d{2}-\\d{2}", phoneNumber);
    }

    public boolean validationName(String name) { // проверка имени
        return Pattern.matches("^[a-zA-Z].{0,14}$", name);
    }

    public String enterPhoneNumber() {
        System.out.println("Введите номер телефона(в формате 12-34-56): ");
        String phoneNumber = terminal.next();
        while (!validationPhoneNumber(phoneNumber)) {
            System.out.println("Неверный ввод!");
            System.out.println("Введите номер телефона: ");
            phoneNumber = terminal.next();
        }
        return phoneNumber;
    }

    public String enterName() {
        System.out.println("Введите имя: ");
        String name = terminal.next();
        while (!validationName(name)) {
            System.out.println("Неправильный ввод!");
            System.out.println("Введите имя: ");
            name = terminal.next();
        }
        return name;
    }

    public void commandSwitch(int command) {
        switch (command) {
            case (1):
                addPhoneNumberAndName();
                break;
            case (2):
                findPhoneNumber();
                break;
            case (3):
                delete();
                break;
            case (4):
                getListOfNumber();
                break;
        }


    }

    public void start() {
        System.out.println("Команды: \n" +
                "1 - add phoneNumber, name \n" +
                "2 - find phoneNumber \n" +
                "3 - delete phoneNumber \n" +
                "4 - list \n" +
                "5 - exit");
        int command = 0;
        while (command != 5) {
            System.out.println("Введите номер команды: ");
            if (terminal.hasNextInt()){
                command = terminal.nextInt();
                commandSwitch(command);
                System.out.println("Команды: \n" +
                        "1 - add phoneNumber, name \n" +
                        "2 - find phoneNumber \n" +
                        "3 - delete phoneNumber \n" +
                        "4 - list \n" +
                        "5 - exit");
            }else {
                System.out.println("Это не число!");
                break;
            }

        }
    }

    public static void main(String[] args) {
        PhoneDirectory p1 = new PhoneDirectory();
        p1.start();
    }
}
