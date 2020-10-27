package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Product item1 = new Book(1, "Little Women", 100, "Louisa May Alcott");
    private Product item2 = new Book(2, "The Adventures of Sherlock Holmes", 200, "A. Conan Doyle");
    private Product item3 = new Smartphone(3, "A53", 500, "Samsung");
    private Product item4 = new Smartphone(4, "iPhone XR", 1000, "Apple");

    @BeforeEach
    void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("Louisa May Alcott");
        Product[] expected = new Product[]{item1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] actual = manager.searchBy("The Adventures of Sherlock Holmes");
        Product[] expected = new Product[]{item2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] actual = manager.searchBy("A53");
        Product[] expected = new Product[]{item3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{item4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameNotExist () {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product actual = repository.findById(15);
        assertNull(actual);
    }
}
