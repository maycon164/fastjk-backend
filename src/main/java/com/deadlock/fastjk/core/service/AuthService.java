package com.deadlock.fastjk.core.service;

import com.deadlock.fastjk.core.dto.LoginDTO;
import com.deadlock.fastjk.data.auth.GoogleProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final GoogleProvider provider;

    public String login(LoginDTO loginDTO) {

        return "jwt token";
    }
}
