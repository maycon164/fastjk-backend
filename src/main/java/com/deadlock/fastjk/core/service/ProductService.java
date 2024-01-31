package com.deadlock.fastjk.core.service;

import com.deadlock.fastjk.core.dto.ProductDTO;
import com.deadlock.fastjk.core.model.Product;
import com.deadlock.fastjk.data.entities.ProductEntity;
import com.deadlock.fastjk.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String addNewProduct(ProductDTO productDTO) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(productDTO.name())
                .price(productDTO.price())
                .description(productDTO.description())
                .barCode(productDTO.barCode())
                .quantity(productDTO.quantity())
                .createdAt(LocalDate.now())
                .build();

        productRepository.save(productEntity);

        return "Service will handle product";
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll().stream().map(this::toProductModel).toList();
    }


    private Product toProductModel(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .quantity(productEntity.getQuantity())
                .createdAt(productEntity.getCreatedAt())
                .build();
    }
}
