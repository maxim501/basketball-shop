package com.am.basketballshop.converters.company;

import com.am.basketballshop.model.product.Company;
import com.am.basketballshop.api.dto.CompanyDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompanyDtoToEntity implements Converter<CompanyDto, Company> {
    @Override
    public Company convert(CompanyDto source) {
        Company company = new Company();

        if (source.getId() != null) {
            company.setId(source.getId());
        }

        company.setName(source.getName());
        return company;
    }
}
