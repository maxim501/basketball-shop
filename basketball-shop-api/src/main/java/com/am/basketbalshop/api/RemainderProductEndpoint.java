package com.am.basketbalshop.api;

import com.am.basketbalshop.api.dto.remainderProduct.RequestRemainderProductDto;
import com.am.basketbalshop.api.dto.remainderProduct.ResponseRemainderProductDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface RemainderProductEndpoint {

    @PostMapping(value = "/")
    ResponseRemainderProductDto createRemainderProduct(@RequestBody RequestRemainderProductDto remainderProductDto);
}
