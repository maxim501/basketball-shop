package com.am.basketbalshop.api.dto.remainderProduct;

import com.am.basketbalshop.api.dto.SizeDto;
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
    private SizeDto size;
    private String remainder;
}
