package ru.phonebook.model;

import java.util.List;

public interface IRecordStorage {
    void addRecord(Record record);
    boolean findRecordByPhone(String phone);
    void deleteRecord(Record record);
    List<String> getAllRecords();
}
