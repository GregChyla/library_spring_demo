package com.greg.library.library.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus (value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler (NullPointerException.class)
    @ResponseBody
    public UserMessageview nullPointerException(NullPointerException e) {

        UserMessageview message = new UserMessageview();
        log.error("NULL POINTER: " + e.getMessage());
        message.setMessage("NULL POINTER " + e.getMessage());
        message.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        return message;
    }

}
