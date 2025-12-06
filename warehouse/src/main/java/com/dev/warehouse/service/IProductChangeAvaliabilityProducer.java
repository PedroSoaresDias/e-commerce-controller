package com.dev.warehouse.service;

import com.dev.warehouse.domain.dto.StockStatusMessage;

public interface IProductChangeAvaliabilityProducer {
    void notifyStatusChange(final StockStatusMessage message);
}
