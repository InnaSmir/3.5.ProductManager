package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {

    private Product first = new Book(1,"Name1", 1, "author1");
    private Product second = new Book(2,"Name2", 2, "author2");
    private Product third = new Smartphone(3,"Name3", 3, "fabric1");
    private Product fourth = new Smartphone(4,"Name4", 4, "fabric1");


    @Test
    void shouldFindByBookNameIfExists() {
        boolean actual = first.matches("Name1");
        assertTrue(actual);
    }

    @Test
    void shouldNotFindByBookNameIfNotExists() {
        boolean actual = first.matches("Name5");
        assertFalse(actual);
    }

    @Test
    void shouldFindByBookAuthorIfExists() {
        boolean actual = second.matches("author2");
        assertTrue(actual);
    }

    @Test
    void shouldNotFindByBookAuthorIfNotExists() {
        boolean actual = second.matches("author3");
        assertFalse(actual);
    }

    @Test
    void shouldFindBySmartphoneNameIfExists() {
        boolean actual = third.matches("Name3");
        assertTrue(actual);
    }

    @Test
    void shouldNotFindBySmartphoneNameIfNotExists() {
        boolean actual = third.matches("Name5");
        assertFalse(actual);
    }

    @Test
    void shouldFindByFabricatorIfExists() {
        boolean actual = fourth.matches("fabric1");
        assertTrue(actual);
    }

    @Test
    void shouldNotFindByFabricatorIfNotExists() {
        boolean actual = fourth.matches("fabric2");
        assertFalse(actual);
    }

}