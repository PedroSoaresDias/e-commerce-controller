package com.dev.warehouse.service;

import java.util.UUID;

import com.dev.warehouse.domain.model.Product;

public interface IProductQueryService {
    Product findById(UUID id);
}
