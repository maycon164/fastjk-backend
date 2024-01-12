package com.deadlock.fastjk.core.model;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record Product (
    String name,
    String description,
    Double price,
    LocalDate createdAt
){}
