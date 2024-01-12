package com.deadlock.fastjk.core.service;

import com.deadlock.fastjk.core.dto.SaleDTO;
import com.deadlock.fastjk.data.entities.SaleEntity;
import com.deadlock.fastjk.data.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public String registerNewSale(SaleDTO saleDTO) {
        return "handle sale";
    }

    public List<SaleEntity> getAllSales() {
        return saleRepository.findAll();
    }
}
