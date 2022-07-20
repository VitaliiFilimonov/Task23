package ru.phonebook.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HashtableRecordStorage implements IRecordStorage{
    private static final Logger LOGGER = LogManager.getLogger(HashtableRecordStorage.class);
    Hashtable<String, String> listOfNumber = new Hashtable();

    @Override
    public void addRecord(Record record) {
        listOfNumber.put(record.getPhone(), record.getFio());
    }

    @Override
    public boolean isRecordExists(String phone) {
        if (listOfNumber.containsKey(phone)) {
            System.out.println("Найденное поле \n" + " Имя: " + listOfNumber.get(phone)
                    + ", Номер телефона: " + phone);
            LOGGER.info("Найденное поле \n" + " Имя: " + listOfNumber.get(phone)
                    + ", Номер телефона: " + phone);
            return true;
        }
        else {
            System.out.println("Поле не найдено!");
            LOGGER.info("Поле не найдено!");
            return false;
        }
    }

    @Override
    public void deleteRecord(String phoneNumber) {
        if(!listOfNumber.isEmpty()){
            listOfNumber.remove(phoneNumber);
            LOGGER.info("Запись удалена! ");
        }else{
            LOGGER.info("Таблица пуста! ");
        }
    }


    @Override
    public List<Record> getListOfAllRecords() {
        Enumeration allPhones = listOfNumber.keys();
        List<Record> recordList = new ArrayList<>();

        while (allPhones.hasMoreElements()) {
            String phone = (String)allPhones.nextElement();
            recordList.add(new Record(phone, listOfNumber.get(phone)));
        }
        return recordList;
    }
}
