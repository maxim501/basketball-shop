package com.am.basketballshop.converters.product;

import com.am.basketballshop.model.product.*;
import com.am.basketbalshop.api.dto.CompanyDto;
import com.am.basketbalshop.api.dto.ProductModelDto;
import com.am.basketbalshop.api.dto.SectionDto;
import com.am.basketbalshop.api.dto.product.ResponseProductDto;
import com.am.basketbalshop.api.dto.subSection.ResponseSubSectionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductEntityToDto implements Converter<Product, ResponseProductDto> {

    @Override
    public ResponseProductDto convert(Product source) {
        return ResponseProductDto.builder()
                .id(source.getId())
                .company(convert(source.getCompany()))
                .nameModel(source.getNameModel())
                .novelty(source.getNovelty())
                .summa(source.getSumma())
                .vendorCode(source.getVendorCode())
                .productModels(source.getProductModels().stream()
                        .map(this::convert)
                        .collect(Collectors.toList()))
                .description(source.getDescription())
                .subSection(convert(source.getSubSection()))
                .build();
    }

    private CompanyDto convert(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }

    private ProductModelDto convert(ProductModel productModel) {
        return ProductModelDto.builder()
                .id(productModel.getId())
                .name(productModel.getName())
                .code(productModel.getCode())
                .build();
    }

    private ResponseSubSectionDto convert(SubSection subSection) {
        return ResponseSubSectionDto.builder()
                .id(subSection.getId())
                .name(subSection.getName())
                .section(convert(subSection.getSection()))
                .build();
    }

    private SectionDto convert(Section section) {
        return SectionDto.builder()
                .id(section.getId())
                .name(section.getName())
                .build();
    }
}
