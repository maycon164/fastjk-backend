package com.deadlock.fastjk.controller;

import com.deadlock.fastjk.core.dto.ProductDTO;
import com.deadlock.fastjk.core.model.Product;
import com.deadlock.fastjk.core.model.User;
import com.deadlock.fastjk.core.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@Validated
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_TESTEZIN')")
    public ResponseEntity<List<Product>> getProducts() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.addNewProduct(productDTO));
    }

    @GetMapping("/search")
    public ResponseEntity<Product> getProductByCodeOrId (@RequestParam(required = false) String barCode, @RequestParam(required = false) Long productId) {

        if(isNull(barCode) && isNull(productId)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productService.getProductByCodeOrById(barCode, productId));
    }
}
