package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.ProductModelDto;
import com.am.basketballshop.api.dto.product.RequestProductDto;
import com.am.basketballshop.api.dto.product.ResponseProductDto;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/{productId}")
    void updateProduct(@PathVariable String productId, @RequestBody RequestProductDto productDto);

    @DeleteMapping(value = "/{productId}")
    void deleteProduct(@PathVariable String productId);
}
