package com.deadlock.fastjk.core.service;

import com.deadlock.fastjk.core.dto.ProductDTO;
import com.deadlock.fastjk.data.entities.ProductEntity;
import com.deadlock.fastjk.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String addNewProduct(ProductDTO productDTO) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(productDTO.name())
                .price(productDTO.price())
                .quantity(productDTO.quantity())
                .build();

        productRepository.save(productEntity);

        return "Service will handle product";
    }
}
