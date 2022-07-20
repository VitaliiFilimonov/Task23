package ru.phonebook.model;

import java.util.Hashtable;
import java.util.List;

public interface IRecordStorage {
    void addRecord(Record record);
    boolean findRecordByPhone(String phone);
    void deleteRecord(String phoneNumber);
    void getAllRecords();
    Hashtable<String, String> getListOfNumber();
    //void getListOfAllRecords();
}
