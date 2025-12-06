package com.dev.warehouse.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dev.warehouse.domain.model.Product;
import com.dev.warehouse.domain.repository.ProductRepository;
import com.dev.warehouse.service.IProductQueryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductQueryServiceImpl implements IProductQueryService {
    private final ProductRepository productRepository;
    
    @Override
    public Product findById(UUID id) {
        return productRepository.findById(id).orElseThrow();
    }

}
