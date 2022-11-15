package com.am.basketballshop.converters.subsection;

import com.am.basketballshop.model.product.Section;
import com.am.basketballshop.model.product.SubSection;
import com.am.basketballshop.api.dto.SectionDto;
import com.am.basketballshop.api.dto.subSection.ResponseSubSectionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubSectionEntityToDto implements Converter<SubSection, ResponseSubSectionDto> {

    @Override
    public ResponseSubSectionDto convert(SubSection source) {
        return ResponseSubSectionDto.builder()
                .id(source.getId())
                .name(source.getName())
                .section(convert(source.getSection()))
                .build();
    }

    private SectionDto convert(Section section) {
        return SectionDto.builder()
                .id(section.getId())
                .name(section.getName())
                .build();
    }
}
