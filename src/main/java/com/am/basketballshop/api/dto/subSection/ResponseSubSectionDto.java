package com.am.basketballshop.api.dto.subSection;

import com.am.basketballshop.model.product.Section;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseSubSectionDto {

    private String id;
    private Section section;
    private String name;
}
