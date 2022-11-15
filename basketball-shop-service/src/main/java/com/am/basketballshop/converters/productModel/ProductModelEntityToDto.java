package com.am.basketballshop.converters.productModel;

import com.am.basketballshop.model.product.ProductModel;
import com.am.basketballshop.api.dto.ProductModelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductModelEntityToDto implements Converter<ProductModel, ProductModelDto> {

    @Override
    public ProductModelDto convert(ProductModel source) {
        return ProductModelDto.builder()
                .id(source.getId())
                .name(source.getName())
                .code(source.getCode())
                .build();
    }
}
