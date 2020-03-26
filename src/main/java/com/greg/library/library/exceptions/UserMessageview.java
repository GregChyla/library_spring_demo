package com.greg.library.library.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserMessageview {
    private LocalDateTime timestamp;
    private String message;
    private HttpStatus httpStatus;
}
