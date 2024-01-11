package com.deadlock.fastjk.controller;

import com.deadlock.fastjk.core.dto.AuthResponseDTO;
import com.deadlock.fastjk.core.dto.LoginDTO;
import com.deadlock.fastjk.core.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid LoginDTO loginDTO){
        return ResponseEntity.ok(authService.login(loginDTO));
    }

}
