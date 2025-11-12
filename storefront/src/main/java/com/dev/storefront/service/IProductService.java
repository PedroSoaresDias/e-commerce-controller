package com.dev.storefront.service;

import java.util.List;
import java.util.UUID;

import com.dev.storefront.domain.dto.ProductInfoDTO;
import com.dev.storefront.domain.model.Product;

public interface IProductService {
    Product save(final Product product);

    void changeActivated(final UUID id, final boolean active);

    List<Product> findAllActive();

    ProductInfoDTO findInfo(final UUID id);

    void purchase(final UUID id);
}
