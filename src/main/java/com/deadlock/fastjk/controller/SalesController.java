package com.deadlock.fastjk.controller;

import com.deadlock.fastjk.core.dto.SaleDTO;
import com.deadlock.fastjk.core.model.User;
import com.deadlock.fastjk.core.service.SaleService;
import com.deadlock.fastjk.data.entities.SaleEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SalesController {

    private final SaleService salesService;

    @PostMapping
    public ResponseEntity<SaleEntity> registerSale(@RequestBody @Valid SaleDTO saleDTO) {
        return ResponseEntity.ok(salesService.registerNewSale(User.builder().build(), saleDTO));
    }

    @GetMapping
    public ResponseEntity<List<SaleEntity>> getAllSales(@RequestParam(name="date") String date) {
        return ResponseEntity.ok(salesService.getSalesByDate(date));
    }
}
