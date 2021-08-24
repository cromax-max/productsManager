package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductsRepository;

public class ProductsManager {
    private ProductsRepository repo;

    public ProductsManager(ProductsRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
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
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().equals(search)) {
                return true;
            }
            if (book.getName().equals(search)) {
                return true;
            }
        }
        if (product instanceof Smartphone) {
            Smartphone phone = (Smartphone) product;
            if (phone.getName().equals(search)) {
                return true;
            }
            if (phone.getManufacturer().equals(search)) {
                return true;
            }
        }
        return false;
    }
}
