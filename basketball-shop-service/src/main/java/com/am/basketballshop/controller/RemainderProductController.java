package com.am.basketballshop.controller;

import com.am.basketballshop.api.RemainderProductEndpoint;
import com.am.basketballshop.api.dto.remainderProduct.RemainderProductDto;
import com.am.basketballshop.services.RemainderProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/remainder")
public class RemainderProductController implements RemainderProductEndpoint {

    private final RemainderProductService remainderProductService;

    @Override
    public List<RemainderProductDto> getRemainderProduct(String productModelId) {
        return remainderProductService.getRemainderProduct(productModelId);
    }

    @Override
    public RemainderProductDto getRemainder(String remainderId) {
        return remainderProductService.getRemainder(remainderId);
    }


    @Override
    public RemainderProductDto createRemainderProduct(RemainderProductDto remainderProductDto) {
        return remainderProductService.createRemainderProduct(remainderProductDto);
    }

    @Override
    public RemainderProductDto updateRemainderProduct(String remainderProductId, RemainderProductDto remainderProductDto) {
        return remainderProductService.updateRemainderProduct(remainderProductId, remainderProductDto);
    }

    @Override
    public void deleteRemainderProduct(String remainderProductId) {
        remainderProductService.deleteRemainderProduct(remainderProductId);
    }

}
