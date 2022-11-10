package com.am.basketballshop.api.dto;

import com.am.basketballshop.model.product.RemainderProduct;
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
public class ProductModelDto {
    private String id;
    private String name;
    private String code;
    private List<RemainderProduct> remainderProductList;
}
