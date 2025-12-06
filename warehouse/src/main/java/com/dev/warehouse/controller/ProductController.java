package com.dev.warehouse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.warehouse.mapper.IProductMapper;
import com.dev.warehouse.service.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final IProductService productService;
    private final IProductMapper mapper;
}
