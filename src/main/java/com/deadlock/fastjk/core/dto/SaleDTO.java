package com.deadlock.fastjk.core.dto;

import com.deadlock.fastjk.core.model.enums.PaymentMethod;

import java.util.List;

public record SaleDTO (
    Long userId,
    Long locationId,
    PaymentMethod paymentMethod,
    List<SaleItemDTO> items,
    Double moneyReceived,
    Double change,
    Double discount,
    Double total
) {}
