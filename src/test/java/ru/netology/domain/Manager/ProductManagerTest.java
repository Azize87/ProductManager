package ru.netology.domain.Manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Repozitory.ProductRepository;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    @Test
    public void searchText() {
        ProductRepository repository = new ProductRepository();
        ProductManager productManager = new ProductManager(repository);

        Book firstBook = new Book(1, "Book first", 50, "Me");
        Book secondBook = new Book(2, "Book second", 60, "Me");
        Smartphone firstSmart = new Smartphone(3, "Smart first", 120, "China");
        Smartphone secondSmart = new Smartphone(4, "Smart second", 320, "China");
        Product firstProduct = new Product(5, "Product", 0);

        productManager.addProduct(firstBook);
        productManager.addProduct(secondBook);
        productManager.addProduct(firstSmart);
        productManager.addProduct(secondSmart);
        productManager.addProduct(firstProduct);

        Product[] actual = productManager.searchBy("first");
        Product[] expected = new Product[]{firstBook, firstSmart};

        assertArrayEquals(expected, actual);
    }


}