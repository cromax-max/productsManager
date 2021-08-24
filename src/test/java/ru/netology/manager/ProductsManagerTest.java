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
    Product book = new Book(101, "Java", 800, "Yakov Fain");
    Product phone1 = new Smartphone(121, "P30", 1300, "Orange");
    Product phone2 = new Smartphone(122, "P50", 1000, "Orange");

    @BeforeEach
    void setup() {
        manager.add(book);
        manager.add(phone1);
        manager.add(phone2);

        Product[] returned = {book, phone1, phone2};
        doReturn(returned).when(repository).findAll();
    }

    @Test
    void shouldSearchEmpty() {
        Product[] expected = new Product[0];
        assertArrayEquals(expected, manager.searchBy("Phyton"));
    }

    @Test
    void shouldSearchOne() {
        Product[] expected = {book};
        assertArrayEquals(expected, manager.searchBy("Java"));
    }

    @Test
    void shouldSearchSeveral() {
        Product[] expected = {phone1, phone2};
        assertArrayEquals(expected, manager.searchBy("Orange"));
    }
}