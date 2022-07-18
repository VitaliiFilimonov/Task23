package ru.phonebook.model;

import java.util.List;

public interface IRecordStorage {
    void addRecord(Record record);
    void findRecord(Record record);
    void deleteRecord(Record record);
    List<Record> getAllRecords();

}
