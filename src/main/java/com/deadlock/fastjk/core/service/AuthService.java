package com.deadlock.fastjk.core.service;

import com.deadlock.fastjk.core.dto.LoginDTO;
import com.deadlock.fastjk.core.model.User;
import com.deadlock.fastjk.data.auth.GoogleProvider;
import com.deadlock.fastjk.data.auth.GoogleUserDTO;
import com.deadlock.fastjk.data.entities.UserEntity;
import com.deadlock.fastjk.data.repository.UserRepository;
import com.deadlock.fastjk.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final GoogleProvider provider;
    private final UserRepository userRepository;

    public String login(LoginDTO loginDTO) {
        GoogleUserDTO googleUserDTO = provider.authenticateGoogleInformation(loginDTO.token());

        System.out.println(googleUserDTO);

        UserEntity user = userRepository.findByEmail(googleUserDTO .email())
                .orElseThrow(UserNotFound::new);

        return "jwt token";
    }

    private User buildUser(){
        throw new RuntimeException("not implemented");
    }
}
