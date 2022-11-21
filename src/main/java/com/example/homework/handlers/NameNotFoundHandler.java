package com.example.homework.handlers;

import com.example.homework.exceptions.NameFoundationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class NameNotFoundHandler {

    @ExceptionHandler(NameFoundationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<?> handleName(NameFoundationException ex){
        String error = ex.getLocalizedMessage();
        return ResponseEntity.unprocessableEntity().body(error);
    }
}
