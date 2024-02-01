package com.deadlock.fastjk.core.service;

import com.deadlock.fastjk.core.dto.ProductDTO;
import com.deadlock.fastjk.core.model.Product;
import com.deadlock.fastjk.data.entities.ProductEntity;
import com.deadlock.fastjk.data.repository.ProductRepository;
import com.deadlock.fastjk.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.util.Objects.isNull;

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

    public Product getProductByCodeOrById(String barCode, Long productId){
        ProductEntity productEntity;

        if(!isNull(barCode)) {
            productEntity = productRepository.findByBarCode(barCode).orElseThrow(() -> new NotFoundException("product not found!"));
        } else {
            productEntity =  productRepository.findById(productId).orElseThrow(() -> new NotFoundException("product not found!"));
        }

        return toProductModel(productEntity);
    }

    private Product toProductModel(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .quantity(productEntity.getQuantity())
                .barCode(productEntity.getBarCode())
                .createdAt(productEntity.getCreatedAt())
                .build();
    }

}
