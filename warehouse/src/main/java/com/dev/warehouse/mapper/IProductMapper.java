package com.dev.warehouse.mapper;

import org.mapstruct.Mapper;

import com.dev.warehouse.domain.dto.ProductStorefrontSaveDTO;
import com.dev.warehouse.domain.model.Product;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    ProductStorefrontSaveDTO toDTO(final Product product);
}
