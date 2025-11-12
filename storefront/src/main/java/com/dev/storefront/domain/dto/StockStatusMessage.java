package com.dev.storefront.domain.dto;

import java.util.UUID;

public record StockStatusMessage(UUID id, String status) {
    public boolean active() {
        return status.equals("AVAILABLE");
    }
}
