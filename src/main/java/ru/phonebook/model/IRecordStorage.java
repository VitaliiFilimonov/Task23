package ru.phonebook.model;

import java.util.Hashtable;
import java.util.List;

public interface IRecordStorage {
    void addRecord(Record record);

    // Метод findXXX должен возвращать либо List<Record> либо Record (объект или null; лучше Optional<Record> )
    //boolean findRecordByPhone(String phone);
    void deleteRecord(String phoneNumber);

    // Должен возвращать List<Record> и называться не get a findAllRecords   ( для единообразия)
    //void getAllRecords();

    // Не понятно, для чего нужен метод (не используется). НО ЭТО ОТКРЫТИЕ РЕАЛЗИАЦИИ.
    boolean isRecordExists(String phone);
    void printAllRecords();
    List<Record> getListOfAllRecords();
}
