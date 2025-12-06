package com.dev.warehouse.domain.dto;

import java.util.UUID;

import com.dev.warehouse.domain.model.StockStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public record StockStatusMessage(
        @JsonProperty("id") UUID id,
        @JsonProperty("status") StockStatus status) {

}
