package com.deadlock.fastjk.data.entities;

import com.deadlock.fastjk.core.model.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "sale")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleEntity {
    @Id
    private Long id;
    @ManyToOne
    private UserEntity seller;
    @OneToMany
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private List<SaleItemEntity> items;
    private Long locationId;
    private Double discount;
    private Double total;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private LocalDate createdAt;
}
