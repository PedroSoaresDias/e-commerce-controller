package com.dev.storefront.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.storefront.controller.request.ProductSaveRequest;
import com.dev.storefront.controller.response.ProductAvailabilityResponse;
import com.dev.storefront.controller.response.ProductDetailResponse;
import com.dev.storefront.controller.response.ProductSavedResponse;
import com.dev.storefront.mapper.IProductMapper;
import com.dev.storefront.service.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {
    private final IProductService productService;
    private final IProductMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductSavedResponse create(@RequestBody final ProductSaveRequest request) {
        var entity = mapper.toEntity(request);
        entity = productService.save(entity);
        return mapper.toResponse(entity);
    }

    @PostMapping("{id}/purchase")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void purchase(@PathVariable("id") final UUID id) {
        productService.purchase(id);
    }

    @GetMapping
    List<ProductAvailabilityResponse> listAvailable() {
        var products = productService.findAllActive();
        return mapper.toResponse(products);
    }
    
    @GetMapping("{id}")
    ProductDetailResponse findById(@PathVariable("id") final UUID id) {
        var dto = productService.findInfo(id);
        return mapper.toResponse(dto);
    }
}
