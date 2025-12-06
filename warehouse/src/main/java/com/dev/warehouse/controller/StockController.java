package com.dev.warehouse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.warehouse.mapper.IStockMapper;
import com.dev.warehouse.service.IStockService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/stocks")
@AllArgsConstructor
public class StockController {
    private final IStockService stockService;
    private final IStockMapper mapper;
}
