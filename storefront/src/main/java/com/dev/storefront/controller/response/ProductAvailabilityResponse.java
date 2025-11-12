package com.dev.storefront.controller.response;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductAvailabilityResponse(
        @JsonProperty("id") UUID id,
        @JsonProperty("name") String name) {

}
