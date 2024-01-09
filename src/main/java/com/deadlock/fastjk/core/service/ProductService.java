package com.deadlock.fastjk.core.service;

import com.deadlock.fastjk.core.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public String addNewProduct(ProductDTO productDTO) {
        return "Service will handle product";
    }
}
