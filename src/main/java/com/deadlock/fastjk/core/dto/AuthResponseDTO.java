package com.deadlock.fastjk.core.dto;

import com.deadlock.fastjk.core.model.User;

public record AuthResponseDTO(
        User user,
        String jwtToken
){ }
