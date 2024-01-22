package com.deadlock.fastjk.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private Long id;
    @ManyToOne
    private ProductEntity product;
    private Integer quantity;
    private Double discount;
    private Double total;

}
