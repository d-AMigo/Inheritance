package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(3, "A53", 500, "Samsung");

    @Test
    void shouldMatchByManufacturer() {
        boolean actual = smartphone.matches("Samsung");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByManufacturer() {
        boolean actual = smartphone.matches("LG");
        assertFalse(actual);
    }

    @Test
    void shouldMatchByName() {
        boolean actual = smartphone.matches("A53");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByName() {
        boolean actual = smartphone.matches("X");
        assertFalse(actual);
    }

}