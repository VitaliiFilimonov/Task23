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
    public void findRecord(Record record) {
        if (listOfNumber.containsKey(record.getPhone())) {
            LOGGER.info("Найденное поле \n" + " Имя: " + listOfNumber.get(record.getPhone())
                    + ", Номер телефона: " + record.getPhone());
        }
    }

    @Override
    public void deleteRecord(Record record) {
        if(!listOfNumber.isEmpty()){
            listOfNumber.remove(record.getPhone());
            LOGGER.info("Запись удалена! ");
        }else{
            LOGGER.info("Таблица пуста! ");
        }
    }

    @Override
    public List<String> getAllRecords() {
        List<String> stringList = new ArrayList<>();
        Enumeration allPhones = listOfNumber.keys();

        while (allPhones.hasMoreElements()) {
            String str = (String)allPhones.nextElement();
            String str2 = "Имя: " + listOfNumber.get(str) + ", Номер телефона: "
                    + str;
            stringList.add(str2);
        }
        return stringList;
    }
}
