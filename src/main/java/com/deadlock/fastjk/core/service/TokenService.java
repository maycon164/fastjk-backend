package com.deadlock.fastjk.core.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.deadlock.fastjk.core.model.User;
import com.deadlock.fastjk.core.model.enums.Role;
import com.deadlock.fastjk.data.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private final String SECRET = "token secret!" ;
    private final Algorithm algorithm = Algorithm.HMAC256(SECRET);
    private final String CLAIM_ID = "ID";
    private final String CLAIM_EMAIL = "EMAIL";
    private final String CLAIM_ACCESS = "TYPE ACCESS";
    public String generateToken(UserEntity userEntity){

        String token = JWT.create()
                .withClaim(CLAIM_ID, userEntity.getId())
                .withClaim(CLAIM_EMAIL, userEntity.getEmail())
                .withClaim(CLAIM_ACCESS, userEntity.getTypeAccess().toString())
                .withExpiresAt(LocalDateTime.now().plusDays(2).toInstant(ZoneOffset.of("-03:00")))
                .sign(algorithm);

        return token;
    }

    public User validateTokenAndGetUser(String token) {
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        return User.builder()
                .id(decodedJWT.getClaim(CLAIM_ID).asLong())
                .email(decodedJWT.getClaim(CLAIM_EMAIL).asString())
                .role(Role.valueOf(decodedJWT.getClaim(CLAIM_ACCESS).asString()))
                .build();
    }

}
