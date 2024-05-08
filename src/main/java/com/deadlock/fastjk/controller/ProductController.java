package com.deadlock.fastjk.controller;

import com.deadlock.fastjk.core.dto.ProductDTO;
import com.deadlock.fastjk.core.model.Product;
import com.deadlock.fastjk.core.model.User;
import com.deadlock.fastjk.core.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
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
    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    public ResponseEntity<List<Product>> getProducts() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.addNewProduct(productDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    public ResponseEntity<String> updateProduct(@PathVariable(name = "id") Long productId, @RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProduct(productId, productDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    public ResponseEntity removeProduct(@PathVariable(name = "id") Long productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    public ResponseEntity<Product> getProductByCodeOrId (@RequestParam(required = false) String barCode) {

        if(isNull(barCode)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productService.getProductByCode(barCode));
    }
}
