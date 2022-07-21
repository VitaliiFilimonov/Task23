package ru.phonebook.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneViewTest {

    @Test
    void isValidationFioPass() {
        IPhoneBookView phoneBookView = new PhoneView();
        boolean actual1 = phoneBookView.isValidationFioPass("123123213");
        boolean expected1 = false;
        assertEquals(expected1, actual1);

        boolean actual2 = phoneBookView.isValidationFioPass("Vasya123");
        boolean expected2 = true;
        assertEquals(expected2, actual2);
    }

    @Test
    void isValidationPhoneNumberPass() {
        IPhoneBookView phoneBookView = new PhoneView();
        boolean actual1 = phoneBookView.isValidationPhoneNumberPass("123123213");
        boolean expected1 = false;
        assertEquals(expected1, actual1);

        boolean actual2 = phoneBookView.isValidationPhoneNumberPass("11-11-11");
        boolean expected2 = true;
        assertEquals(expected2, actual2);
    }
}