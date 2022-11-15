package com.am.basketballshop.services;

import com.am.basketballshop.converters.base.UniversalConverter;
import com.am.basketballshop.model.product.ProductModel;
import com.am.basketballshop.model.product.RemainderProduct;
import com.am.basketballshop.model.product.Size;
import com.am.basketballshop.repository.ProductModelRepository;
import com.am.basketballshop.repository.RemainderProductRepository;
import com.am.basketballshop.repository.SizeRepository;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketbalshop.api.dto.remainderProduct.RequestRemainderProductDto;
import com.am.basketbalshop.api.dto.remainderProduct.ResponseRemainderProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RemainderProductService {

    private final RemainderProductRepository remainderProductRepository;
    private final ProductModelRepository productModelRepository;
    private final SizeRepository sizeRepository;
    private final UniversalConverter converter;


    public ResponseRemainderProductDto createRemainderProduct(@RequestBody RequestRemainderProductDto remainderProductDto){
        RemainderProduct remainderProduct = new RemainderProduct();
        String productModelId = remainderProductDto.getProductModelId();
        String sizeId = remainderProductDto.getSizeId();
        remainderProduct.setRemainder(remainderProductDto.getRemainder());

        if (productModelId != null){
            Optional<ProductModel> colorById = productModelRepository.findById(productModelId);
            ProductModel productModel = colorById.orElseThrow(() -> {
                throw new NotFoundException("Not found product model by id = " + productModelId);
            });
            remainderProduct.setProductModel(productModel);
        }

        if (sizeId != null) {
            Optional<Size> sizeById = sizeRepository.findById(sizeId);
            Size size = sizeById.orElseThrow(() -> {
                throw new NotFoundException("Not found size by id = " + sizeId);
            });
            remainderProduct.setSize(size);
        }

        RemainderProduct saveRemainderProduct = remainderProductRepository.save(remainderProduct);

        return converter.entityToDto(saveRemainderProduct, ResponseRemainderProductDto.class);
    }

}
