package ru.phonebook.model;

import java.util.List;
import java.util.Optional;

public class PhoneBookController implements IPhoneBookController {

    private final IRecordStorage recordStorage;
    private final IPhoneBookView view;

    public PhoneBookController(IRecordStorage recordStorage, IPhoneBookView view) {
        this.recordStorage = recordStorage;
        this.view = view;
    }

    @Override
    public void start() {
        while (true) {
            Optional<Command> command = view.nextCommand();
            if (command.isEmpty()) break;

            switch (command.get()) {
                case ADD:
                    addPhone();
                    break;
                case DELETE:
                    deletePhone();
                    break;
                case LIST:
                    showRecords();
                    break;
            }

        }
    }

    void showRecords() {
        List<Record> recordList = recordStorage.getListOfAllRecords();
        view.showRecords(recordList);
    }

    void addPhone() {
        String phoneNumber = view.readPhoneNumber();
        // TODO проверка ввода
        boolean ok = true; // ok = validate(phoneNUmber)
        if (!ok) {
            view.printError("Ошибка ввода");
            return;
        }
        String fio = view.readFio();
        // TODO проверка ввода
        ok = true; // ok = validate(fio)
        if (!ok) {
            view.printError("Ошибка ввода");
            return;
        }
        Record record = new Record(phoneNumber, fio);
        recordStorage.addRecord(record);
    }

    void deletePhone() {
        String phoneNumber = view.readPhoneNumber();
        // проверка ввода
        recordStorage.deleteRecord(phoneNumber);
    }
}
