package com.deadlock.fastjk.controller;

import com.deadlock.fastjk.core.dto.ProductDTO;
import com.deadlock.fastjk.core.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<String> getProducts() {
        System.out.println(productService);
        return ResponseEntity.ok("i will get all your products .... soon");
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.addNewProduct(productDTO));
    }
}
