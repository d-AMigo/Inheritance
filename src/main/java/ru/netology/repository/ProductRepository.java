package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

public class ProductRepository {
    Product[] items = {
            new Book(1, "Little Women", 100, "Louisa May Alcott"),
            new Book(2, "The Adventures of Sherlock Holmes", 200, "A. Conan Doyle"),
            new Smartphone(3, "A53", 500, "Samsung"),
            new Smartphone(4, "iPhone XR", 1000, "Apple")
    };

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public  Product[] findAll(){
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}