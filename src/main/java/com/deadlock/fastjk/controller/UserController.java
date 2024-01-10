package com.deadlock.fastjk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    private String hello() {
        return "FAST JK - SAYS HELLO WORLD";
    }
}
