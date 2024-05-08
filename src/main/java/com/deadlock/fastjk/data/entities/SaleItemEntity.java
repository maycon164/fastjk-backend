package com.deadlock.fastjk.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "sale_item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ProductEntity product;
    private Integer quantity;
    private Double discount;
    private Double total;

}
