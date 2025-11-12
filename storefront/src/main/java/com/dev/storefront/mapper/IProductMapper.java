package com.dev.storefront.mapper;

import java.math.BigDecimal;

import org.mapstruct.Mapper;

import com.dev.storefront.domain.dto.ProductInfoDTO;
import com.dev.storefront.domain.model.Product;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    ProductInfoDTO toDTO(final Product product, final BigDecimal price);
}
