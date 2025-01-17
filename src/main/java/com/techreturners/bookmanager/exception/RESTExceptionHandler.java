package com.techreturners.bookmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RESTExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NoBookException.class)
    public ResponseEntity<Object> handleBookNotFound(NoBookException ex, WebRequest request){
        return new ResponseEntity<>( new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler(DuplicateBookException.class)
    public ResponseEntity<Object> handleDuplicateBook(DuplicateBookException ex, WebRequest request){
        return new ResponseEntity<>( new ApiError(ex.getMessage(), HttpStatus.CONFLICT, LocalDateTime.now()), HttpStatus.CONFLICT );
    }

}
