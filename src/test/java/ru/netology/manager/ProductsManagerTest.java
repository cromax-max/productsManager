package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductsRepository;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductsManagerTest {
    @Mock
    ProductsRepository repository;
    @InjectMocks
    ProductsManager manager;
    Product book1 = new Book(101, "Java", 800, "Horstmann");
    Product book2 = new Book(102, "Java", 800, "Joshua Bloch");
    Product phone1 = new Smartphone(121, "P30", 1300, "Orange");
    Product phone2 = new Smartphone(122, "P50", 1000, "Orange");

    @BeforeEach
    void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] returned = {book1, book2, phone1, phone2};
        doReturn(returned).when(repository).findAll();
    }

    @Test
    void shouldSearchEmpty() {
        Product[] expected = new Product[0];
        assertArrayEquals(expected, manager.searchBy("Space"));
    }

    @Test
    void shouldSearchByBookName() {
        Product[] expected = {book1, book2};
        assertArrayEquals(expected, manager.searchBy("Java"));
    }

    @Test
    void shouldSearchByBookAuthor() {
        Product[] expected = {book2};
        assertArrayEquals(expected, manager.searchBy("Joshua Bloch"));
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = {phone1};
        assertArrayEquals(expected, manager.searchBy("P30"));
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = {phone1, phone2};
        assertArrayEquals(expected, manager.searchBy("Orange"));
    }
}