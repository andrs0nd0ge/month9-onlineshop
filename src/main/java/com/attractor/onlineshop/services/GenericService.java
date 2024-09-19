package com.attractor.onlineshop.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GenericService {
    public <T> ResponseEntity<List<T>> returnResponseForList(List<T> list) {
        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
    }
}
