package com.example.homework.handlers;

import com.example.homework.exceptions.IdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class NonExistentIdHandler {

    @ExceptionHandler(IdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<?> handleId(IdException ex) {
        String error = ex.getLocalizedMessage();
        return ResponseEntity.unprocessableEntity().body(error);
    }
}
