package com.am.basketballshop.controller;

import com.am.basketballshop.api.RemainderProductEndpoint;
import com.am.basketballshop.api.dto.remainderProduct.RequestRemainderProductDto;
import com.am.basketballshop.api.dto.remainderProduct.ResponseRemainderProductDto;
import com.am.basketballshop.services.RemainderProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/remainder")
public class RemainderProductController implements RemainderProductEndpoint {

    private final RemainderProductService remainderProductService;

    @Override
    public ResponseRemainderProductDto createRemainderProduct(RequestRemainderProductDto remainderProductDto) {
        return remainderProductService.createRemainderProduct(remainderProductDto);
    }

    @Override
    public void updateRemainderProduct(String remainderProductId, RequestRemainderProductDto remainderProductDto) {
        remainderProductService.updateRemainderProduct(remainderProductId, remainderProductDto);
    }

    @Override
    public void deleteRemainderProduct(String remainderProductId) {
        remainderProductService.deleteRemainderProduct(remainderProductId);
    }

}
