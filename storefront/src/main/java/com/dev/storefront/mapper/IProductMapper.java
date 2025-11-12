package com.dev.storefront.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.storefront.controller.request.ProductSaveRequest;
import com.dev.storefront.controller.response.ProductAvailabilityResponse;
import com.dev.storefront.controller.response.ProductDetailResponse;
import com.dev.storefront.controller.response.ProductSavedResponse;
import com.dev.storefront.domain.dto.ProductInfoDTO;
import com.dev.storefront.domain.model.Product;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    ProductInfoDTO toDTO(final Product product, final BigDecimal price);

    @Mapping(target = "active", constant = "false")
    Product toEntity(final ProductSaveRequest request);

    ProductSavedResponse toResponse(final Product product);

    List<ProductAvailabilityResponse> toResponse(final List<Product> products);

    ProductDetailResponse toResponse(final ProductInfoDTO dto);
}
