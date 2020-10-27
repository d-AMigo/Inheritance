package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;


class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product item1 = new Book(1, "Little Women", 100, "Louisa May Alcott");
    private Product item2 = new Book(2, "The Adventures of Sherlock Holmes", 200, "A. Conan Doyle");
    private Product item3 = new Smartphone(3, "A53", 500, "Samsung");
    private Product item4 = new Smartphone(4, "iPhone XR", 1000, "Apple");

    private Product itemToSave = new Book(123, "Book", 139, "Author");

    @BeforeEach
    void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
    }

    @Test
    void shouldSave() {
        repository.save(itemToSave);
        Product[] actual = repository.findAll();
        Product[] expected = {
                item1,
                item2,
                item3,
                item4,
                itemToSave
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Product actual = repository.findById(1);
        Product expected = item1;
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByIdNotExist() {
        Product actual = repository.findById(111);
        assertEquals(null, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {
                item2,
                item3,
                item4
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNotExist() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(55));
    }
}