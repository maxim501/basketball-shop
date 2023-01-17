package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.remainderProduct.RemainderProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RemainderProductEndpoint {

    @GetMapping(value = "/{remainderId}")
    RemainderProductDto getRemainder(@PathVariable String remainderId);

    @GetMapping(value = "/productModel/{productModelId}")
    List<RemainderProductDto> getRemainderProduct(@RequestParam String productModelId);

    @PostMapping(value = "/")
    RemainderProductDto createRemainderProduct(@RequestBody RemainderProductDto remainderProductDto);

    @PutMapping(value = "/{remainderProductId}")
    RemainderProductDto updateRemainderProduct(@PathVariable String remainderProductId, @RequestBody RemainderProductDto remainderProductDto);

    @DeleteMapping(value = "/{remainderProductId}")
    void deleteRemainderProduct(@PathVariable String remainderProductId);
}
