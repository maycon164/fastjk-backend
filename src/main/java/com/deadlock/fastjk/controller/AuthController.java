package com.deadlock.fastjk.controller;

import com.deadlock.fastjk.core.dto.LoginDTO;
import com.deadlock.fastjk.core.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private ResponseEntity<String> login(LoginDTO loginDTO){
        return ResponseEntity.ok("Access Token being returned");
    }

}
