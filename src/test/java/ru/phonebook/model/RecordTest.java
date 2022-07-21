package ru.phonebook.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {

    @Test
    void getFioTest() {
        Record record = new Record();
        record.setFio("Vasya");
        String actual = record.getFio();
        String expected = "Vasya";
        assertEquals(expected, actual);
    }


    @Test
    void getPhoneTest() {
        Record record = new Record();
        record.setPhone("11-11-11");
        String actual = record.getPhone();
        String expected = "11-11-11";
        assertEquals(expected, actual);
    }


    @Test
    void testToString() {
        Record record = new Record("11-11-11", "Vasya");
        String actual = record.toString();
        String expected = "Имя: " + record.getFio() + ", телефон: " + record.getPhone();
        assertEquals(expected, actual);
    }
}