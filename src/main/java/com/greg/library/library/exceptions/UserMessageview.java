package com.greg.library.library.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UserMessageview {
    private String message;
    private HttpStatus httpStatus;
}
