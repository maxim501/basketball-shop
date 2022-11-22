package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.remainderProduct.RequestRemainderProductDto;
import com.am.basketballshop.api.dto.remainderProduct.ResponseRemainderProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RemainderProductEndpoint {

    @GetMapping(value = "/productModel/{productModelId}")
    List<ResponseRemainderProductDto> getRemainderProduct(@RequestParam String productModelId);

    @PostMapping(value = "/")
    ResponseRemainderProductDto createRemainderProduct(@RequestBody RequestRemainderProductDto remainderProductDto);

    @PutMapping(value = "/{remainderProductId}")
    ResponseRemainderProductDto updateRemainderProduct(@PathVariable String remainderProductId, @RequestBody RequestRemainderProductDto remainderProductDto);

    @DeleteMapping(value = "/{remainderProductId}")
    void deleteRemainderProduct(@PathVariable String remainderProductId);
}
