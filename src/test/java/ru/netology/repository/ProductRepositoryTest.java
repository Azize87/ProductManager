package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Book firstBook = new Book(1, "Book first", 50, "Me");
    Book secondBook = new Book(2, "Book second", 60, "Me");

    @BeforeEach
    public void setUp() {
        repository.save(firstBook);
        repository.save(secondBook);
    }

    @Test
    public void searchById() {

        repository.save(firstBook);
        repository.save(secondBook);


        Product actual = repository.findById(2);
        Product expected = secondBook;

        assertEquals(expected, actual);
    }

    @Test
    public void searchByIdFindNone() {
        Product actual = repository.findById(3);
        Product expected = null;

        assertEquals(expected, actual);
    }

    @Test
    public void removeById() {
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{firstBook};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeOfNonexistentId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }

}