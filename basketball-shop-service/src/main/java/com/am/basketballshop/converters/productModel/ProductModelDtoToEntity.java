package com.am.basketballshop.converters.productModel;

import com.am.basketballshop.api.dto.ProductModelDto;
import com.am.basketballshop.model.product.ProductModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductModelDtoToEntity implements Converter<ProductModelDto, ProductModel> {

    @Override
    public ProductModel convert(ProductModelDto source) {
        ProductModel productModel = new ProductModel();
        if(source.getId() != null){
            productModel.setId(source.getId());
        }
        productModel.setCode(source.getCode());
        productModel.setName(source.getName());
        return productModel;
    }
}