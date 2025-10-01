package com.moon.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalCustomException {

    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handlerProductNotFoundException(ProductNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(); // icini doldurmag = return emeliyyati
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setCode(HttpStatus.NOT_FOUND.value());
        return errorResponse;

    }
}





