package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.ProductModelDto;
import com.am.basketballshop.api.dto.product.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductEndpoint {

    @PostMapping(value = "/")
    ProductDto createProduct(@RequestBody ProductDto productDto);

    @GetMapping(value = "/{productId}")
    ProductDto getProduct(@PathVariable String productId);

    @GetMapping(value = "/subsection/{subSectionId}")
    List<ProductDto> getBySubSection(@PathVariable String subSectionId);

    @GetMapping(value = "/{productId}/remainder")
    List<ProductModelDto> getRemainedColorProduct(@PathVariable String productId);

    @PutMapping(value = "/{productId}")
    ProductDto updateProduct(@PathVariable String productId, @RequestBody ProductDto productDto);

    @DeleteMapping(value = "/{productId}")
    void deleteProduct(@PathVariable String productId);
}
