package com.deadlock.fastjk.core.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.deadlock.fastjk.data.entities.UserEntity;
import org.springframework.stereotype.Service;

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
                .sign(algorithm);

        return token;
    }

}
