package com.greg.library.library.mapper;

import lombok.Data;

@Data
public class BookDTO {

    private Long id;
    private String name;
    private String writer;
    private String genre;
    private String year;
}
