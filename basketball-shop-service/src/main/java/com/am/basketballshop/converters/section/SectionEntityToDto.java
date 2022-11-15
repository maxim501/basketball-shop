package com.am.basketballshop.converters.section;

import com.am.basketballshop.model.product.Section;
import com.am.basketballshop.api.dto.SectionDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SectionEntityToDto implements Converter<Section, SectionDto> {

    @Override
    public SectionDto convert(Section source) {
        return SectionDto.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
