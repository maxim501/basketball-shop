package com.am.basketbalshop.api;

import com.am.basketbalshop.api.dto.ProductModelDto;
import com.am.basketbalshop.api.dto.product.RequestProductDto;
import com.am.basketbalshop.api.dto.product.ResponseProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductEndpoint {

    @PostMapping(value = "/")
    ResponseProductDto createProduct(@RequestBody RequestProductDto productDto);

    @GetMapping(value = "/{productId}")
    ResponseProductDto getProduct(@PathVariable String productId);

    @GetMapping(value = "/subsection/{subSectionId}")
    List<ResponseProductDto> getBySubSection(@PathVariable String subSectionId);

    @GetMapping(value = "/{productId}/remainder")
    List<ProductModelDto> getRemainedColorProduct(@PathVariable String productId);

}
