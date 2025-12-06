package com.dev.warehouse.service.impl;

import static com.dev.warehouse.domain.model.StockStatus.AVAILABLE;
import static com.dev.warehouse.domain.model.StockStatus.UNAVAILABLE;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dev.warehouse.domain.dto.StockStatusMessage;
import com.dev.warehouse.domain.model.Stock;
import com.dev.warehouse.domain.model.StockStatus;
import com.dev.warehouse.domain.repository.StockRepository;
import com.dev.warehouse.service.IProductChangeAvaliabilityProducer;
import com.dev.warehouse.service.IProductQueryService;
import com.dev.warehouse.service.IStockService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StockServiceImpl implements IStockService {
    private final StockRepository stockRepository;
    private final IProductQueryService productService;
    private final IProductChangeAvaliabilityProducer producer;
    
    @Override
    public Stock save(Stock stock) {
        stock.setProduct(productService.findById(stock.getProduct().getId()));
        return stockRepository.save(stock);
    }

    @Override
    public void release(UUID id) {
        changeStatus(id, AVAILABLE);
    }

    @Override
    public void inactive(UUID id) {
        changeStatus(id, UNAVAILABLE);
    }

    @Override
    public void changeStatus(UUID id, StockStatus status) {
        var entity = stockRepository.findById(id).orElseThrow();
        entity.setStatus(status);
        stockRepository.save(entity);
        producer.notifyStatusChange(new StockStatusMessage(entity.getProduct().getId(), status));
    }

}
