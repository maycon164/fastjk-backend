package com.deadlock.fastjk.data.repository;

import com.deadlock.fastjk.data.entities.SaleItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItemEntity, Long> {
}
