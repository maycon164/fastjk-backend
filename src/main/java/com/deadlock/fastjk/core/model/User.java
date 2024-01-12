package com.deadlock.fastjk.core.model;

import com.deadlock.fastjk.core.model.enums.TypeAccess;
import lombok.Builder;

@Builder
public record User(
        String name,
        String email,
        String photo,
        TypeAccess typeAccess
) {
}
