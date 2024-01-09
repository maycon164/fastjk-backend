package com.deadlock.fastjk.core.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductDTO (
        @NotBlank
        String name,
        @Positive @NotNull @NotBlank
        Double price,
        @Positive @NotNull @Min(1)
        Integer quantity
) { }
