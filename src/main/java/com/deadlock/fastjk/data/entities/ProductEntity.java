package com.deadlock.fastjk.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "product")
public class ProductEntity {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    @Column(name = "bar_code")
    private String barCode;

    private LocalDate createdAt;

}
