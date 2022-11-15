package com.am.basketballshop.api.dto.remainderProduct;

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
public class RequestRemainderProductDto {
    private String id;
    private String productModelId;
    private String sizeId;
    private String remainder;
}
