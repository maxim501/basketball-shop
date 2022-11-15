package com.am.basketballshop.converters.remainderproduct;

import com.am.basketballshop.model.product.RemainderProduct;
import com.am.basketballshop.model.product.Size;
import com.am.basketbalshop.api.dto.SizeDto;
import com.am.basketbalshop.api.dto.remainderProduct.ResponseRemainderProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemainderProductEntityToDto implements Converter<RemainderProduct, ResponseRemainderProductDto> {

    @Override
    public ResponseRemainderProductDto convert(RemainderProduct source) {
        return ResponseRemainderProductDto.builder()
                .id(source.getId())
                .remainder(source.getRemainder())
                .size(convert(source.getSize()))
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
