package com.greg.library.library.controller;

import com.greg.library.library.mapper.BookDTO;
import com.greg.library.library.mapper.BookMapper;
import com.greg.library.library.model.Book;
import com.greg.library.library.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping ("/books")
public class BookController {

    private BookService bookService;
    private BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping ()
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookService.findAll();
        return books.stream()
                .map(book -> bookMapper.mapBookEntityToDto(book))
                .peek(bookDTO -> log.info("BOOK DTO from mapper: " + bookDTO.toString()))
                .collect(Collectors.toList());
    }

    @GetMapping ("/name/{bookName}")
    public BookDTO getBookByName(@PathVariable ("bookName") String name) {
        return bookMapper.mapBookEntityToDto(bookService.findByName(name));
    }

    @PostMapping (value = "/save")
    public ResponseEntity<?> saveOrUpdateBook(@RequestBody BookDTO bookDTO) {
        bookService.save(bookMapper.mapBookDtoToEntity(bookDTO));
        return new ResponseEntity<>("Book saved", HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{bookName}")
    public ResponseEntity<?> delete(@PathVariable String bookName) {
        bookService.delete(bookService.findByName(bookName));
        return new ResponseEntity<>("Book deleted", HttpStatus.OK);
    }
}
