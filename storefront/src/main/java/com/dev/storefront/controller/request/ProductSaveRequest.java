package com.dev.storefront.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductSaveRequest(
        @JsonProperty("name") String name) {

}
