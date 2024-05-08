package com.deadlock.fastjk.controller;

import com.deadlock.fastjk.exceptions.NotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
@RestController
@ControllerAdvice("")
public class ControllerAdviceFastJk {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFound() {
        return ResponseEntity.notFound().build();
    }
}
