package com.deadlock.fastjk.core.service;

import com.deadlock.fastjk.core.dto.AuthResponseDTO;
import com.deadlock.fastjk.core.dto.LoginDTO;
import com.deadlock.fastjk.core.model.User;
import com.deadlock.fastjk.data.auth.GoogleProvider;
import com.deadlock.fastjk.data.auth.GoogleUserDTO;
import com.deadlock.fastjk.data.entities.UserEntity;
import com.deadlock.fastjk.data.repository.UserRepository;
import com.deadlock.fastjk.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final GoogleProvider provider;
    private final UserRepository userRepository;
    private final TokenService jwtService;

    public AuthResponseDTO login(LoginDTO loginDTO) {
        GoogleUserDTO googleUserDTO = provider.authenticateGoogleInformation(loginDTO.token());

        UserEntity userEntity = userRepository.findByEmail(googleUserDTO .email())
                .orElseThrow(UserNotFound::new);

        User user = buildUser(googleUserDTO, userEntity);

        String jwtToken = jwtService.generateToken(userEntity);

        return new AuthResponseDTO(user, jwtToken);
    }

    private User buildUser(GoogleUserDTO googleUserDTO, UserEntity userEntity){
        return User.builder()
                .name(isNull(userEntity.getName()) ? googleUserDTO.name() : userEntity.getName())
                .email(userEntity.getEmail())
                .photo(googleUserDTO.picture())
                .role(userEntity.getTypeAccess())
                .build();
    }
}
