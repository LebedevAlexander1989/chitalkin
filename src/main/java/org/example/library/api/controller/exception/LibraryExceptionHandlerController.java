package org.example.library.api.controller.exception;

import org.example.library.api.dto.ResponseErrorDto;
import org.example.library.api.exception.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class LibraryExceptionHandlerController {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseErrorDto handleNotFoundException(NotFoundException ex) {
        return new ResponseErrorDto(ex.getMessage());
    }
}
