package ru.netology.domain.Manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Repozitory.ProductRepository;
import ru.netology.domain.Smartphone;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getTitle().contains(search)) {
            return true;
        }
        if (product instanceof Book) {
            Book book = (Book) product;
            return book.getAuthor().contains(search);
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            return smartphone.getManufacturer().contains(search);
        }
        return false;
    }
}
