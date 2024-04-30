package com.deadlock.fastjk.core.model;

import com.deadlock.fastjk.core.model.enums.Role;
import lombok.Builder;

@Builder
public record User(
        Long id,
        String name,
        String email,
        String photo,
        Location location,
        Role role
) {
}
