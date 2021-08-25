package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Product book = new Book(101, "Java", 800, "Horstmann");

    @ParameterizedTest
    @CsvSource({"Java", "Horstmann"})
    void shouldBeExistent (String text) {
        assertTrue(book.matches(text));
    }

    @ParameterizedTest
    @CsvSource({"Ruby", "Yakov Fain"})
    void shouldBeNonExistent(String text) {
        assertFalse(book.matches(text));
    }
}