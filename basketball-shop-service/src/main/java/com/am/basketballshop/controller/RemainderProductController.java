package com.am.basketballshop.controller;

import com.am.basketballshop.services.RemainderProductService;
import com.am.basketbalshop.api.RemainderProductEndpoint;
import com.am.basketbalshop.api.dto.remainderProduct.RequestRemainderProductDto;
import com.am.basketbalshop.api.dto.remainderProduct.ResponseRemainderProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/remainder")
public class RemainderProductController implements RemainderProductEndpoint {

    private final RemainderProductService remainderProductService;

    @Override
    public ResponseRemainderProductDto createRemainderProduct(@RequestBody RequestRemainderProductDto remainderProductDto) {
        return remainderProductService.createRemainderProduct(remainderProductDto);
    }

}
