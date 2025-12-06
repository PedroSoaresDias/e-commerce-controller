package com.dev.warehouse.service;

import java.util.UUID;

import com.dev.warehouse.domain.model.Product;

public interface IProductService {
    Product save(final Product product);

    Product findById(final UUID id);

    void purchase(final UUID id);
}
