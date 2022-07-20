package ru.phonebook.model;

import java.util.List;

public interface IRecordStorage {
    void addRecord(Record record);
    void deleteRecord(String phoneNumber);
    boolean isRecordExists(String phone);
    List<Record> getListOfAllRecords();
}
