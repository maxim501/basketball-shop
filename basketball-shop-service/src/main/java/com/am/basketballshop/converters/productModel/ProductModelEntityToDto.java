package com.am.basketballshop.converters.productModel;

import com.am.basketballshop.converters.base.UniversalConverter;
import com.am.basketballshop.model.product.ProductModel;
import com.am.basketballshop.model.product.RemainderProduct;
import com.am.basketballshop.repository.RemainderProductRepository;
import com.am.basketbalshop.api.dto.ProductModelDto;
import com.am.basketbalshop.api.dto.SizeDto;
import com.am.basketbalshop.api.dto.remainderProduct.ResponseRemainderProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

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
