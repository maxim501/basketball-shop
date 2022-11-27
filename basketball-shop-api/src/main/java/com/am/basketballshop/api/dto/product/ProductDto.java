package com.am.basketballshop.api.dto.product;

import com.am.basketballshop.api.dto.ProductModelDto;
import com.am.basketballshop.api.dto.subSection.ResponseSubSectionDto;
import com.am.basketballshop.api.dto.CompanyDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private String id;
    private CompanyDto company;
    private String nameModel;
    private Boolean novelty;
    private String vendorCode;
    private List<ProductModelDto> productModels;
    private String description;
    private ResponseSubSectionDto subSection;
    private Integer summa;
}
