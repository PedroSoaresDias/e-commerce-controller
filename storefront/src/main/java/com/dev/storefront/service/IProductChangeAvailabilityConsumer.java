package com.dev.storefront.service;

import com.dev.storefront.domain.dto.StockStatusMessage;

public interface IProductChangeAvailabilityConsumer {
    void receive(final StockStatusMessage message);
}
