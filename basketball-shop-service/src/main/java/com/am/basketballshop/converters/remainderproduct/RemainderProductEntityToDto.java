package com.am.basketballshop.converters.remainderproduct;

import com.am.basketballshop.api.dto.SizeDto;
import com.am.basketballshop.api.dto.remainderProduct.RemainderProductDto;
import com.am.basketballshop.model.product.RemainderProduct;
import com.am.basketballshop.model.product.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemainderProductEntityToDto implements Converter<RemainderProduct, RemainderProductDto> {

    @Override
    public RemainderProductDto convert(RemainderProduct source) {
        return RemainderProductDto.builder()
                .id(source.getId())
                .productModelId(source.getProductModel().getId())
                .remainder(source.getRemainder())
                .sizeId(convert(source.getSize()))
                .build();
    }

    private SizeDto convert(Size size) {
        return SizeDto.builder()
                .id(size.getId())
                .code(size.getCode())
                .name(size.getName())
                .build();
    }
}
