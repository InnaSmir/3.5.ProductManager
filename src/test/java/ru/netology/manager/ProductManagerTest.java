package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductRepository productRepository = new ProductRepository();
    ProductManager productManager = new ProductManager(productRepository);

    private Product first = new Book(1,"Name1", 1, "author1");
    private Product second = new Book(2,"Name2", 2, "author2");
    private Product third = new Smartphone(3,"Name3", 3, "fabric1");
    private Product fourth = new Smartphone(4,"Name4", 4, "fabric1");
    private Product fifth = new Product(5,"Name5", 5);

    @BeforeEach
    public void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
        productManager.add(fourth);
        productManager.add(fifth);
    }

    @Test
    void shouldSearchByName() {
        Product[] expected = {second};
        Product[] actual = productManager.searchBy("Name2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchByNameIfNotExists() {
        Product[] expected = {};
        Product[] actual = productManager.searchBy("Name8");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByFabricator() {
        Product[] expected = {fourth};
        Product[] actual = productManager.searchBy("Name4");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfEmptyRepository() {
        Product[] expected = {};
        Product[] actual = productManager.searchBy("");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySameFabric() {
        Product[] expected = {third, fourth};
        Product[] actual = productManager.searchBy("fabric1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = {third};
        Product[] actual = productManager.searchBy("Name3");
        assertArrayEquals(expected, actual);
    }


}
