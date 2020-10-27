package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book = new Book(1, "Little Women", 100, "Louisa May Alcott");

    @Test
    void shouldMatchByAuthor() {
        boolean actual = book.matches("Louisa May Alcott");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByAuthor() {
        boolean actual = book.matches("Dostoevsky");
        assertFalse(actual);
    }

    @Test
    void shouldMatchByName() {
        boolean actual = book.matches("Little Women");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByName() {
        boolean actual = book.matches("Harry Potter");
        assertFalse(actual);
    }

}