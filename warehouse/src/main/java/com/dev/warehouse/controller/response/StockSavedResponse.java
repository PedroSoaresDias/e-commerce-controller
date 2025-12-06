package com.dev.warehouse.controller.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.dev.warehouse.domain.model.StockStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public record StockSavedResponse(
        @JsonProperty("id") UUID id,
        @JsonProperty("amount") Long amount,
        @JsonProperty("boughtPrice") BigDecimal boughtPrice,
        @JsonProperty("status") StockStatus status,
        @JsonProperty("soldPrice") BigDecimal soldPrice,
        @JsonProperty("productId") UUID productId,
        @JsonProperty("productName") String productName
) {

}
