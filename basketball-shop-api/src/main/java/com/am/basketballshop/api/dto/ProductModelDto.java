package com.am.basketballshop.api.dto;

import com.am.basketballshop.api.dto.remainderProduct.RemainderProductDto;
import com.am.basketballshop.api.dto.remainderProduct.ResponseRemainderProductDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductModelDto {
    private String id;
    private String name;
    private String code;
    private List<RemainderProductDto> remainderProductList;
}
