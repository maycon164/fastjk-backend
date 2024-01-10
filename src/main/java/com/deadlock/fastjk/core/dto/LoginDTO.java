package com.deadlock.fastjk.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginDTO (
        @NotNull
        @NotBlank
        String token
) { }
