package com.dev.warehouse.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.dev.warehouse.domain.dto.ProductStorefrontSaveDTO;
import com.dev.warehouse.domain.model.Product;
import com.dev.warehouse.domain.repository.ProductRepository;
import com.dev.warehouse.mapper.IProductMapper;
import com.dev.warehouse.service.IProductService;
import com.dev.warehouse.service.IStockService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    private final IStockService stockService;
    private final RestClient storefrontClient;
    private final IProductMapper mapper;

    @Override
    public Product save(Product product) {
        productRepository.save(product);
        var dto = mapper.toDTO(product);
        saveStorefront(dto);
        return product;
    }

    @Override
    public Product findById(UUID id) {
        return productRepository.findById(id).orElseThrow();
    }
    
    @Override
    public void purchase(UUID id) {
        var entity = findById(id);
        var stock = entity.decStock();
        productRepository.save(entity);
        if (stock.isUnavailable()) {
            stockService.changeStatus(entity.getId(), stock.getStatus());
        }
    }
    
    private void saveStorefront(ProductStorefrontSaveDTO dto) {
        storefrontClient.post()
        .uri("/products")
        .body(dto)
        .retrieve()
                .body(ProductStorefrontSaveDTO.class);
    }
}
