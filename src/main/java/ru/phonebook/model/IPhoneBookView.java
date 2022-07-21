package ru.phonebook.model;

import java.util.List;
import java.util.Optional;

public interface IPhoneBookView {
    Optional<Command> nextCommand();

    Record readRecord();

    String readPhoneNumber();

    void showRecords(List<Record> recordList);

    void printError(String error);

    String readFio();

    boolean isValidationPhoneNumberPass(String phoneNumber);

    boolean isValidationFioPass(String fio);
}
