package ru.phonebook.model;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneView implements IPhoneBookView{
    Scanner terminal = new Scanner(System.in);

    @Override
    public Optional<Command> nextCommand() {
        int command;
        Command cmd = null;

        System.out.println("Команды: \n" +
                "1 - add phoneNumber, name \n" +
                "2 - find phoneNumber \n" +
                "3 - delete phoneNumber \n" +
                "4 - list \n" +
                "5 - exit");
        System.out.println("Введите номер команды: ");
        command = terminal.nextInt();

        switch (command){
            case 1:
                cmd = Command.ADD;
                break;
            case 2:
                cmd = Command.FIND;
                break;
            case 3:
                cmd = Command.DELETE;
                break;
            case 4:
                cmd = Command.LIST;
                break;
            case 5:
                cmd = Command.EXIT;
                break;
        }
        System.out.println(cmd);
        return Optional.ofNullable(cmd);
    }

    @Override
    public String readPhoneNumber() {
        System.out.println("Введите номер телефона(в формате 12-34-56): ");
        String phoneNumber = terminal.next();
        while(!isValidationPhoneNumberPass(phoneNumber)){
            System.out.println("Неверный ввод!" + "\n" +
                    "Введите номер телефона: ");
            phoneNumber = terminal.next();
        }
        return phoneNumber;
    }

    @Override
    public void showRecords(List<Record> recordList) {
        for(Record record: recordList){
            System.out.println(record);
        }
    }

    @Override
    public void printError(String error) {
        System.out.println(error);
    }

    @Override
    public String readFio() {
        System.out.println("Введите имя: ");
        String name = terminal.next();
        while(!isValidationFioPass(name)){
            System.out.println("Неправильный ввод!" + "\n" +
                    "Введите имя: ");
            name = terminal.next();
        }
        return name;
    }

    @Override
    public boolean isValidationFioPass(String fio) {
        return Pattern.matches("^[a-zA-Z].{0,14}$", fio);
    }

    @Override
    public boolean isValidationPhoneNumberPass(String phone) {
        return Pattern.matches("\\d{2}-\\d{2}-\\d{2}", phone);
    }
}
