package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    Product phone = new Smartphone(121, "P30", 1300, "Orange");

    @ParameterizedTest
    @CsvSource({"P30", "Orange"})
    void shouldBeExistent(String text) {
        assertTrue(phone.matches(text));
    }

    @ParameterizedTest
    @CsvSource({"I45", "Samsung"})
    void shouldBeNonExistent(String text) {
        assertFalse(phone.matches(text));
    }
}