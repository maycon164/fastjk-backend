package com.deadlock.fastjk.data.repository;

import com.deadlock.fastjk.data.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long> {

    List<SaleEntity> findSalesByCreatedAt(LocalDate date);
}
