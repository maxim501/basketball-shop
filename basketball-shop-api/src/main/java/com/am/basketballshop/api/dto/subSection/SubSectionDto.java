package com.am.basketballshop.api.dto.subSection;

import com.am.basketballshop.api.dto.SectionDto;
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
public class SubSectionDto {

    private String id;
    private SectionDto section;
    private String name;
}
