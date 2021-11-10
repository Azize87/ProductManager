package ru.netology.domain.Repozitory;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRepositoryTest {
    @Test
    public void searchById() {
        ProductRepository repository = new ProductRepository();

        Book firstBook = new Book(1, "Book first", 50, "Me");
        Book secondBook = new Book(2, "Book second", 60, "Me");


        repository.save(firstBook);
        repository.save(secondBook);


        Product actual = repository.findById(2);
        Product expected = secondBook;

        assertEquals(expected, actual);
    }

    @Test
    public void searchByIdFindNone() {
        ProductRepository repository = new ProductRepository();

        Book firstBook = new Book(1, "Book first", 50, "Me");
        Book secondBook = new Book(2, "Book second", 60, "Me");


        repository.save(firstBook);
        repository.save(secondBook);


        Product actual = repository.findById(3);
        Product expected = null;

        assertEquals(expected, actual);
    }

    @Test
    public void removeById() {
        ProductRepository repository = new ProductRepository();

        Book firstBook = new Book(1, "Book first", 50, "Me");
        Book secondBook = new Book(2, "Book second", 60, "Me");


        repository.save(firstBook);
        repository.save(secondBook);


        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{firstBook};

        assertArrayEquals(expected, actual);
    }

}