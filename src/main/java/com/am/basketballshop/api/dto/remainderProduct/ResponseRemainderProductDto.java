package com.am.basketballshop.api.dto.remainderProduct;

import com.am.basketballshop.model.product.ProductModel;
import com.am.basketballshop.model.product.Size;
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
public class ResponseRemainderProductDto {
    private String id;
    private ProductModel productModel;
    private Size size;
    private String remainder;
}
