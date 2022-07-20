package ru.phonebook.model;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PhoneView implements IPhoneBookView{
    Scanner terminal = new Scanner(System.in);
    @Override
    public Optional<Command> nextCommand() {
        int command;
        Command cmd = null;

        System.out.println("Введите номер команды: ");
        System.out.println("Команды: \n" +
                "1 - add phoneNumber, name \n" +
                "2 - find phoneNumber \n" +
                "3 - delete phoneNumber \n" +
                "4 - list \n" +
                "5 - exit");
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

        return Optional.ofNullable(cmd);
    }

    @Override
    public Record readRecord() {
        return null;
    }

    @Override
    public String readPhoneNumber() {
        return null;
    }

    @Override
    public void showRecords(List<Record> recordList) {

    }

    @Override
    public void printError(String error) {

    }

    @Override
    public String readFio() {
        return null;
    }
}
