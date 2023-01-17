package com.am.basketballshop.api.dto.remainderProduct;

import com.am.basketballshop.api.dto.SizeDto;
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
public class RemainderProductDto {
    private String id;
    private String productModelId;
    private SizeDto sizeId;
    private Integer remainder;
}
