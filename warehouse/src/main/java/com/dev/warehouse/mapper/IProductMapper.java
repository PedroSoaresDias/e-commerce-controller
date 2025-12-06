package com.dev.warehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.warehouse.controller.request.ProductSaveRequest;
import com.dev.warehouse.controller.response.ProductDetailResponse;
import com.dev.warehouse.controller.response.ProductSavedResponse;
import com.dev.warehouse.domain.dto.ProductStorefrontSaveDTO;
import com.dev.warehouse.domain.model.Product;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stocks", ignore = true)
    @Mapping(target = "price", ignore = true)
    Product toEntity(final ProductSaveRequest request);

    ProductSavedResponse toSavedResponse(final Product product);
    
    ProductStorefrontSaveDTO toDTO(final Product product);

    ProductDetailResponse toDetailResponse(final Product product);
}
