package com.greg.library.library.service;

import com.greg.library.library.model.Book;
import com.greg.library.library.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findByName(String name) {
        log.info("inside findByName");
        return bookRepository.findByName(name);
    }

    @Override
    public List<Book> findAll() {
        log.info("inside findAll");
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        log.info("inside save");
        log.info("Book: " + book.toString());
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        log.info("inside delete");
        bookRepository.delete(book);
    }
}
