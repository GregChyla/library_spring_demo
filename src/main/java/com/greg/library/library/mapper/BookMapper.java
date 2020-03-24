package com.greg.library.library.mapper;

import com.greg.library.library.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDTO mapBookEntityToDto(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setGenre(book.getGenre());
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setWriter(book.getWriter());
        bookDTO.setYear(book.getYear());
        return bookDTO;
    }

    public Book mapBookDtoToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setGenre(bookDTO.getGenre());
        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setWriter(bookDTO.getWriter());
        book.setYear(bookDTO.getYear());
        return book;
    }

}
