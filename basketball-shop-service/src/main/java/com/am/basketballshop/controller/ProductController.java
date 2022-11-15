package com.am.basketballshop.controller;

import com.am.basketbalshop.api.ProductEndpoint;
import com.am.basketbalshop.api.dto.ProductModelDto;
import com.am.basketbalshop.api.dto.product.RequestProductDto;
import com.am.basketbalshop.api.dto.product.ResponseProductDto;
import com.am.basketballshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController implements ProductEndpoint {

    private final ProductService productService;

    @Override
    public ResponseProductDto createProduct(@RequestBody RequestProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @Override
    public ResponseProductDto getProduct(@PathVariable String productId) {
        return productService.getProduct(productId);
    }

    @Override
    public List<ResponseProductDto> getBySubSection(@PathVariable String subSectionId){
        return productService.getBySubSection(subSectionId);
    }

    @Override
    public List<ProductModelDto> getRemainedColorProduct(@PathVariable String productId){
        return productService.getRemainedColorProduct(productId);
    }
}
