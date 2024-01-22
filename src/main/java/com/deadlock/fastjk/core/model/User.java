package com.deadlock.fastjk.core.model;

import com.deadlock.fastjk.core.model.enums.TypeAccess;
import lombok.Builder;

@Builder
public record User(
        Long id,
        String name,
        String email,
        String photo,
        Location location,
        TypeAccess typeAccess
) {
}
