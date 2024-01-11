package com.deadlock.fastjk.core.service;

import com.deadlock.fastjk.data.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken(UserEntity userEntity){
        return "JWT TOKEN";
    }

}
