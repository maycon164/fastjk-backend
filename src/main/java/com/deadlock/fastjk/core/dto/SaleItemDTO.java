package com.deadlock.fastjk.core.dto;

public record SaleItemDTO (
        Long productId,
        Integer quantity,
        Double discount,
        Double finalPrice
) {
}
