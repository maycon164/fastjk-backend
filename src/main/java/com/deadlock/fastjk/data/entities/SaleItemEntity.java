package com.deadlock.fastjk.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity(name = "sale_item")
@Data
public class SaleItemEntity {
    @Id
    private Long id;
    @ManyToOne
    private ProductEntity product;
    private Integer quantity;
    private Double discount;
    private Double total;

}
