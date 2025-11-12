package com.dev.storefront.domain.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductDetailDTO(
        @JsonProperty("id") UUID id,
        @JsonProperty("name") String name,
        @JsonProperty("price") BigDecimal price) {

}
