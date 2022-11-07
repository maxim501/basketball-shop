package com.am.basketballshop.api.dto.product;

import com.am.basketballshop.api.dto.ColorDto;
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
    private int sum;
    private List<ColorDto> colors;
    private String description;
    private String subSectionId;
}
