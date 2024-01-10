package com.deadlock.fastjk.core.model;

import com.deadlock.fastjk.core.model.enums.TypeAccess;

public record User(
        String name,
        String email,
        TypeAccess typeAccess
) {
}
