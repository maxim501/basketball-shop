package com.am.basketballshop.converters.size;

import com.am.basketballshop.model.product.Size;
import com.am.basketbalshop.api.dto.SizeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SizeEntityToDto implements Converter<Size, SizeDto> {

    @Override
    public SizeDto convert(Size source) {
        return SizeDto.builder()
                .id(source.getId())
                .code(source.getCode())
                .name(source.getName())
                .build();
    }
}
