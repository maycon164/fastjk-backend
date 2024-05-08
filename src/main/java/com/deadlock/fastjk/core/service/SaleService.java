package com.deadlock.fastjk.core.service;

import com.deadlock.fastjk.core.dto.SaleDTO;
import com.deadlock.fastjk.core.dto.SaleItemDTO;
import com.deadlock.fastjk.core.model.User;
import com.deadlock.fastjk.data.entities.*;
import com.deadlock.fastjk.data.repository.LocationRepository;
import com.deadlock.fastjk.data.repository.ProductRepository;
import com.deadlock.fastjk.data.repository.SaleRepository;
import com.deadlock.fastjk.data.repository.UserRepository;
import com.deadlock.fastjk.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    public SaleEntity registerNewSale(User user, SaleDTO saleDTO) {

        LocationEntity location = locationRepository.findById(1L)
                .orElseThrow(() -> new NotFoundException("location not found"));

        UserEntity seller = userRepository.findById(1L)
                .orElseThrow(() -> new NotFoundException("user not found"));

        List<SaleItemEntity> items = saleDTO.items().stream().map(this::getSaleItemEntity).toList();

        double total = items.stream().mapToDouble(SaleItemEntity::getTotal).sum();

        SaleEntity sale =  SaleEntity.builder()
                .locationId(location.getId())
                .seller(seller)
                .paymentMethod(saleDTO.paymentMethod())
                .items(items)
                .moneyReceived(saleDTO.moneyReceived())
                .change(saleDTO.change())
                .createdAt(LocalDate.now())
                .discount(saleDTO.discount())
                .total(total)
                .build();

        return saleRepository.save(sale);
    }

    private SaleItemEntity getSaleItemEntity(SaleItemDTO saleItemDTO) {
        ProductEntity product = productRepository.findById(saleItemDTO.productId())
                .orElseThrow(() -> new NotFoundException("product not found!"));

        // TODO: DISCOUNT PER UNIT OR IN THE TOTAL CALCULATED???

        double total = product.getPrice() * saleItemDTO.quantity() - saleItemDTO.discount();

        updateQuantityOfProduct(product, saleItemDTO.quantity());

        return SaleItemEntity.builder()
                .product(product)
                .quantity(saleItemDTO.quantity())
                .total(total)
                .build();
    }

    private void updateQuantityOfProduct(ProductEntity productEntity, Integer quantity) {
        Integer availableQuantity = productEntity.getQuantity();
        productEntity.setQuantity(availableQuantity - quantity);
        productRepository.save(productEntity);
    }


    public List<SaleEntity> getSalesByDate(String date) {
        LocalDate dateFormatted = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return saleRepository.findSalesByCreatedAt(dateFormatted);
    }
}
