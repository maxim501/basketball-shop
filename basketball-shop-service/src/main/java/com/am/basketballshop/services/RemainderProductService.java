package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.SizeDto;
import com.am.basketballshop.api.dto.remainderProduct.RemainderProductDto;
import com.am.basketballshop.converters.base.UniversalConverter;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketballshop.model.product.ProductModel;
import com.am.basketballshop.model.product.RemainderProduct;
import com.am.basketballshop.model.product.Size;
import com.am.basketballshop.repository.ProductModelRepository;
import com.am.basketballshop.repository.RemainderProductRepository;
import com.am.basketballshop.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RemainderProductService {

    private final RemainderProductRepository remainderProductRepository;
    private final ProductModelRepository productModelRepository;
    private final SizeRepository sizeRepository;
    private final UniversalConverter converter;

    public RemainderProductDto getRemainder(@PathVariable String remainderId) {
        Optional<RemainderProduct> remainderById = remainderProductRepository.findById(remainderId);
        RemainderProduct remainderProduct = remainderById.orElseThrow(() -> {
            throw new NotFoundException("Not found remainder product by id = " + remainderId);
        });

        return RemainderProductDto.builder()
                .id(remainderProduct.getId())
                .sizeId(SizeDto.builder()
                        .id(remainderProduct.getSize().getId())
                        .code(remainderProduct.getSize().getCode())
                        .name(remainderProduct.getSize().getName())
                        .build())
                .remainder(remainderProduct.getRemainder())
                .build();
    }

    public List<RemainderProductDto> getRemainderProduct(String productModelId) {
        return remainderProductRepository.findByProductModelId(productModelId).stream()
                .map(remainderProduct -> converter.entityToDto(remainderProduct, RemainderProductDto.class))
                .collect(Collectors.toList());
    }

    public RemainderProductDto createRemainderProduct(@RequestBody RemainderProductDto remainderProductDto) {
        RemainderProduct remainderProduct = new RemainderProduct();
        setRemainderProduct(remainderProduct, remainderProductDto);

        RemainderProduct saveRemainderProduct = remainderProductRepository.save(remainderProduct);

        return converter.entityToDto(saveRemainderProduct, RemainderProductDto.class);
    }

    public RemainderProductDto updateRemainderProduct(String remainderProductId, RemainderProductDto remainderProductDto) {
        Optional<RemainderProduct> remainderProductById = remainderProductRepository.findById(remainderProductId);
        RemainderProduct remainderProduct = remainderProductById.orElseThrow(() -> {
            throw new NotFoundException("Not found remainder product by id = " + remainderProductId);
        });
        setRemainderProduct(remainderProduct, remainderProductDto);

        RemainderProduct updateRemainderProduct = remainderProductRepository.save(remainderProduct);

        return converter.entityToDto(updateRemainderProduct, RemainderProductDto.class);
    }

    public void deleteRemainderProduct(String remainderProductId) {
        Optional<RemainderProduct> remainderProductById = remainderProductRepository.findById(remainderProductId);
        RemainderProduct remainderProduct = remainderProductById.orElseThrow(() -> {
            throw new NotFoundException("Not found remainder product by id = " + remainderProductId);
        });

        remainderProductRepository.delete(remainderProduct);
    }

    public void setRemainderProduct(RemainderProduct remainderProduct, RemainderProductDto remainderProductDto) {
//        String productModelId = remainderProductDto.getProductModelId().getId();

        String productModelId = remainderProductDto.getProductModelId();
        String sizeId = remainderProductDto.getSizeId().getId();
        remainderProduct.setRemainder(remainderProductDto.getRemainder());

        if (productModelId != null) {
            Optional<ProductModel> productModelById = productModelRepository.findById(productModelId);
            ProductModel productModel = productModelById.orElseThrow(() -> {
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
    }

}
