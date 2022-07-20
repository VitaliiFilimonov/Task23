package ru.homework;

import java.util.*;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.SerializationFeature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ru.phonebook.model.HashtableRecordStorage;
import ru.phonebook.model.IRecordStorage;
import ru.phonebook.model.Record;

import java.io.File;
import java.io.IOException;

public class PhoneDirectory {
    private static final Logger LOGGER = LogManager.getLogger(PhoneDirectory.class);
    IRecordStorage recordStorage = new HashtableRecordStorage();

    Scanner terminal = new Scanner(System.in);


    public void addPhoneNumberAndName() { //добавить номер и имя
        String phoneNumber = enterPhoneNumber();
        while(recordStorage.isRecordExists(phoneNumber)){
            System.out.println("Запись уже создана! Повторите ввод номера: ");
            phoneNumber = enterPhoneNumber();
        }
        String name = enterName();
        Record record = new Record(phoneNumber, name);
        recordStorage.addRecord(record);
        //System.out.println("Запись добавлена! ");
        LOGGER.info("Запись добавлена!");
    }

    public void findPhoneNumber() { // найти по номеру
        String phoneNumber = enterPhoneNumber();
        recordStorage.isRecordExists(phoneNumber);
    }

    public void delete() { //удаление
        String phoneNumber = enterPhoneNumber();
        recordStorage.deleteRecord(phoneNumber);
    }

    public void getListOfNumber() { // вывод списка
        List<Record> recordList = recordStorage.getListOfAllRecords();
        for (Record record: recordList){
            System.out.println(record.toString());
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
        //String filePath = "/home/user/Task22/JsonPhoneDirectory.json";
        //File file = new File(filePath);

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
//                try{
//                    ObjectMapper mapper = new ObjectMapper();
//                    mapper.enable(SerializationFeature.INDENT_OUTPUT);
//                    mapper.writeValue(file, listOfNumber);
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
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
