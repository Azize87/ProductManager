package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager productManager = new ProductManager(repository);

    Book firstBook = new Book(1, "Book first", 50, "Me");
    Book secondBook = new Book(2, "Book second", 60, "You");
    Smartphone firstSmart = new Smartphone(3, "Smart first", 120, "China");
    Smartphone secondSmart = new Smartphone(4, "Smart second", 320, "USA");
    Product firstProduct = new Product(5, "Product", 0);



    @BeforeEach
    public void setUp() {
        productManager.addProduct(firstBook);
        productManager.addProduct(secondBook);
        productManager.addProduct(firstSmart);
        productManager.addProduct(secondSmart);
        productManager.addProduct(firstProduct);
    }


    @Test
    public void searchByTitleText() {
        Product[] actual = productManager.searchBy("first");
        Product[] expected = new Product[]{firstBook, firstSmart};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthorText() {
        Product[] actual = productManager.searchBy("Me");
        Product[] expected = new Product[]{firstBook};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByManufactureText() {
        Product[] actual = productManager.searchBy("USA");
        Product[] expected = new Product[]{secondSmart};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTextReturnEmpty() {
        Product[] actual = productManager.searchBy("Somebody");
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }
}