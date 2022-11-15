package com.am.basketbalshop.api.dto.product;

import com.am.basketbalshop.api.dto.ProductModelDto;
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
public class RequestProductDto {
    private String id;
    private String companyId;
    private String nameModel;
    private Boolean novelty;
    private List<ProductModelDto> productModels;
    private String description;
    private String subSectionId;
    private Integer summa;
}
