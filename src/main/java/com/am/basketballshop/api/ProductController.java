package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.product.RequestProductDto;
import com.am.basketballshop.api.dto.product.ResponseProductDto;
import com.am.basketballshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/")
    ResponseProductDto createProduct(@RequestBody RequestProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping(value = "/{productId}")
    ResponseProductDto getProduct(@PathVariable String productId) {
        return productService.getProduct(productId);
    }
}
