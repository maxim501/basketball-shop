package com.am.basketballshop.converters.company;

import com.am.basketballshop.model.product.Company;
import com.am.basketbalshop.api.dto.CompanyDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompanyEntityToDto implements Converter<Company, CompanyDto> {

    @Override
    public CompanyDto convert(Company source) {
        return CompanyDto.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
