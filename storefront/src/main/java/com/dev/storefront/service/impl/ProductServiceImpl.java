package com.dev.storefront.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.dev.storefront.domain.dto.ProductDetailDTO;
import com.dev.storefront.domain.dto.ProductInfoDTO;
import com.dev.storefront.domain.model.Product;
import com.dev.storefront.domain.repository.ProductRepository;
import com.dev.storefront.mapper.IProductMapper;
import com.dev.storefront.service.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final RestClient warehouseClient;
    private final IProductMapper mapper;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void changeActivated(UUID id, boolean active) {
        var product = findById(id);
        product.setActive(active);
        productRepository.save(product);
    }

    @Override
    public List<Product> findAllActive() {
        return productRepository.findByActiveTrueOrderByNameAsc();
    }

    @Override
    public ProductInfoDTO findInfo(UUID id) {
        var product = findById(id);
        var price = requestCurrentAmount(id);
        return mapper.toDTO(product, price);
    }

    @Override
    public void purchase(UUID id) {
        purchaseWarehouse(id);
    }

    private BigDecimal requestCurrentAmount(UUID id) {
        var dto = warehouseClient.get()
                .uri("/products/" + id)
                .retrieve()
                .body(ProductDetailDTO.class);

        return dto.price();
    }

    private void purchaseWarehouse(UUID id) {
        var path = String.format("/products/%s/purchase", id);
        warehouseClient.post()
        .uri(path)
                .retrieve()
                .toBodilessEntity();
    }

    private Product findById(final UUID id) {
        return productRepository.findById(id).orElseThrow();
    }
}
