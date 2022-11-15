package com.am.basketballshop.converters.section;

import com.am.basketballshop.model.product.Section;
import com.am.basketbalshop.api.dto.SectionDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SectionDtoToEntity implements Converter<SectionDto, Section> {

    @Override
    public Section convert(SectionDto source) {
        Section section = new Section();
        if (source.getId() != null) {
            section.setId(source.getId());
        }
        section.setName(source.getName());
        return section;
    }
}
