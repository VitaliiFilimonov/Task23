package ru.phonebook.model;

public class Record {
    private String fio;
    private String phone;

    public Record(){}

    public Record(String phone, String fio) {
        this.fio = fio;
        this.phone = phone;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
