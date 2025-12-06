package com.dev.warehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.warehouse.controller.request.StockSaveRequest;
import com.dev.warehouse.controller.response.StockSavedResponse;
import com.dev.warehouse.domain.model.Stock;

@Mapper(componentModel = "spring")
public interface IStockMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "status", expression = "java(com.dev.warehouse.domain.model.StockStatus.IN_CONFERENCE)")
    Stock toEntity(final StockSaveRequest request);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.name")
    StockSavedResponse toResponse(final Stock stock);
}
