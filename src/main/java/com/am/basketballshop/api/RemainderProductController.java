package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.remainderProduct.RequestRemainderProductDto;
import com.am.basketballshop.api.dto.remainderProduct.ResponseRemainderProductDto;
import com.am.basketballshop.services.RemainderProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/remainder")
public class RemainderProductController {

    private final RemainderProductService remainderProductService;

    @PostMapping(value = "/")
    ResponseRemainderProductDto creatRemainderProduct(@RequestBody RequestRemainderProductDto remainderProductDto){
        return remainderProductService.creatRemainderProduct(remainderProductDto);
    }

}
