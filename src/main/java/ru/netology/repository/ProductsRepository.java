package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductsRepository {
    Product[] products = new Product[0];

    public void save(Product movie) {
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[tmp.length - 1] = movie;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[products.length];
        int index = 0;
        for (Product movieID : products) {
            if (movieID.getId() != id) {
                tmp[index] = movieID;
                index++;
            }
        }
        products = tmp;
    }
}
