package com.am.basketballshop.api.dto.product;

import com.am.basketballshop.api.dto.ColorDto;
import com.am.basketballshop.model.product.Color;
import com.am.basketballshop.model.product.Company;
import com.am.basketballshop.model.product.SubSection;
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
public class ResponseProductDto {
    private String id;
    private Company company;
    private String nameModel;
    private Boolean novelty;
    private String vendorCode;
    private List<ColorDto> colors;
    private String description;
    private SubSection subSection;
}
