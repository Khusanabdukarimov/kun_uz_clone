package com.example.kunuz_clone.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception {
    @ExceptionHandler
    public ResponseEntity<?> exception(MyException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
