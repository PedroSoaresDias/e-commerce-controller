package com.dev.warehouse.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class StorefrontClientConfig {
    @Bean
    RestClient storefrontClient(@org.springframework.lang.NonNull @Value("${storefront.base-path}") String baseUrl) {
        return RestClient.create(baseUrl);
    }
}
