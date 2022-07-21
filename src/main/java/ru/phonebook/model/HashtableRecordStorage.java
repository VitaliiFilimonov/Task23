package ru.phonebook.model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HashtableRecordStorage implements IRecordStorage {
    private static final Logger LOGGER = LogManager.getLogger(HashtableRecordStorage.class);
    private HashMap<String, String> listOfNumber = new HashMap<>();

    @Override
    public void addRecord(Record record) {
        LOGGER.debug("addRecord {} start ", record);
        listOfNumber.put(record.getPhone(), record.getFio());
        LOGGER.debug("addRecord SUCCESS {} end", record);
    }

    @Override
    public boolean isRecordExists(String phone) {
        boolean result = listOfNumber.containsKey(phone);
        LOGGER.trace("isRecordExists({}) : {}", phone, result);
        return result;
    }

    @Override
    public void deleteRecord(String phoneNumber) {
        LOGGER.debug("deleteRecord {} start", phoneNumber);
        String oldFio = listOfNumber.remove(phoneNumber);
        if (oldFio == null) {
            LOGGER.warn("deleteRecord {}: record did not exist", phoneNumber);
        } else {
            LOGGER.debug("deleteRecord {} success", phoneNumber);
        }

    }


    @Override
    public List<Record> getListOfAllRecords() {
        LOGGER.trace("getListOfAllRecords");
        List<Record> records = listOfNumber.entrySet()
                .stream()
                .map(entry -> new Record(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        LOGGER.trace("getListOfAllRecords size: {}", records.size());
        return records;
    }
}
