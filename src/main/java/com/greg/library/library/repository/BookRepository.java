package com.greg.library.library.repository;

import com.greg.library.library.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();

    Book findByName(String name);

//    Book save(Book book);

    void delete(Book book);

}
