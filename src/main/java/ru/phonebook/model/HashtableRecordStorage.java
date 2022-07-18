package ru.phonebook.model;

import java.util.Hashtable;
import java.util.List;

public class HashtableRecordStorage implements IRecordStorage{
    Hashtable<String, String> listOfNumber = new Hashtable<String, String>();


    @Override
    public void addRecord(Record record) {

    }

    @Override
    public void findRecord(Record record) {

    }

    @Override
    public void deleteRecord(Record record) {

    }

    @Override
    public List<Record> getAllRecords() {
        return null;
    }
}
