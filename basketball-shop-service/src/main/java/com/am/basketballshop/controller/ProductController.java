package com.am.basketballshop.controller;

import com.am.basketballshop.api.ProductEndpoint;
import com.am.basketballshop.api.dto.ProductModelDto;
import com.am.basketballshop.api.dto.product.RequestProductDto;
import com.am.basketballshop.api.dto.product.ResponseProductDto;
import com.am.basketballshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController implements ProductEndpoint {

    private final ProductService productService;

    @Override
    public ResponseProductDto createProduct(RequestProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @Override
    public ResponseProductDto getProduct(String productId) {
        return productService.getProduct(productId);
    }

    @Override
    public List<ResponseProductDto> getBySubSection(String subSectionId) {
        return productService.getBySubSection(subSectionId);
    }

    @Override
    public List<ProductModelDto> getRemainedColorProduct(String productId) {
        return productService.getRemainderProductModel(productId);
    }

    @Override
    public void updateProduct(String productId, RequestProductDto productDto) {
        productService.updateProduct(productId, productDto);
    }

    @Override
    public void deleteProduct(String productId) {
        productService.deleteProduct(productId);
    }

}
