package com.dev.warehouse.service;

import java.util.UUID;

import com.dev.warehouse.domain.model.Stock;
import com.dev.warehouse.domain.model.StockStatus;

public interface IStockService {
    Stock save(final Stock stock);

    void release(final UUID id);

    void inactive(final UUID id);

    void changeStatus(final UUID id, final StockStatus status);
}
