package com.greg.library.library.service;

import com.greg.library.library.model.Book;

import java.util.List;

public interface BookService {
    Book findByName(String name);

    List<Book> findAll();

    Book save(Book book);

    void delete(Book book);

}
