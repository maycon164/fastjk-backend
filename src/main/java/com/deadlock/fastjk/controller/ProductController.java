package com.deadlock.fastjk.controller;

import com.deadlock.fastjk.core.dto.ProductDTO;
import com.deadlock.fastjk.core.model.Product;
import com.deadlock.fastjk.core.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.addNewProduct(productDTO));
    }
}
