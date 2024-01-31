package com.deadlock.fastjk.core.model;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record Product (
        Long id,
        String name,
        String description,
        Double price,
        Integer quantity,
        LocalDate createdAt
){}
