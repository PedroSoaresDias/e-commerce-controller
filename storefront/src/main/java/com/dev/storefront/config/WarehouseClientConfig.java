package com.dev.storefront.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class WarehouseClientConfig {
    @Bean
    RestClient warehouseRestClient(@Value("${warehouse.base-path}") String baseUrl) {
        return RestClient.create(baseUrl);
    }
}
