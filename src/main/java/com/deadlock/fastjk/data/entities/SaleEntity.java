package com.deadlock.fastjk.data.entities;

import com.deadlock.fastjk.model.enums.PaymentMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "sale")
public class SaleEntity {
    @Id
    private Long id;
    private Integer quantity;
    private Double discount;
    private Double total;
    private PaymentMethod paymentMethod;
    private LocalDate createdAt;
}
