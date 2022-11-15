package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.ProductModelDto;
import com.am.basketballshop.api.dto.product.RequestProductDto;
import com.am.basketballshop.api.dto.product.ResponseProductDto;
import com.am.basketballshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/subsection/{subSectionId}")
    List<ResponseProductDto> getBySubSection(@PathVariable String subSectionId) {
        return productService.getBySubSection(subSectionId);
    }

    @GetMapping(value = "/{productId}/remainder")
    List<ProductModelDto> getRemainderProductModel(@PathVariable String productId) {
        return productService.getRemainderProductModel(productId);
    }

    @PutMapping(value = "/{productId}")
    void updateProduct(@PathVariable String productId, @RequestBody RequestProductDto productDto) {
        productService.updateProduct(productId, productDto);
    }

    @DeleteMapping(value = "/{productId}")
    void deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
    }
}
