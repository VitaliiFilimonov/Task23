package ru.phonebook.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.homework.PhoneDirectory;

public class HashtableRecordStorage implements IRecordStorage{
    private static final Logger LOGGER = LogManager.getLogger(HashtableRecordStorage.class);
    Hashtable<String, String> listOfNumber = new Hashtable();

    @Override
    public void addRecord(Record record) {
        listOfNumber.put(record.getPhone(), record.getFio());
    }

    @Override
    public boolean findRecordByPhone(String phone) {
        if (listOfNumber.containsKey(phone)) {
            System.out.println("Найденное поле \n" + " Имя: " + listOfNumber.get(phone)
                    + ", Номер телефона: " + phone);;
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
    public void getAllRecords() {
        Enumeration allPhones = listOfNumber.keys();

        while (allPhones.hasMoreElements()) {
            String str = (String)allPhones.nextElement();
            LOGGER.info("Имя: " + listOfNumber.get(str) + ", Номер телефона: "
                    + str);
        }
    }

    @Override
    public Hashtable<String, String> getListOfNumber(){
        return listOfNumber;
    }
}
