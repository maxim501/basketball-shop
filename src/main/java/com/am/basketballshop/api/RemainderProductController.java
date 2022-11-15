package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.remainderProduct.RequestRemainderProductDto;
import com.am.basketballshop.api.dto.remainderProduct.ResponseRemainderProductDto;
import com.am.basketballshop.services.RemainderProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/remainder")
public class RemainderProductController {

    private final RemainderProductService remainderProductService;

    @PostMapping(value = "/")
    ResponseRemainderProductDto creatRemainderProduct(@RequestBody RequestRemainderProductDto remainderProductDto) {
        return remainderProductService.creatRemainderProduct(remainderProductDto);
    }

    @PutMapping(value = "/{remainderProductId}")
    void updateRemainderProduct(@PathVariable String remainderProductId, @RequestBody RequestRemainderProductDto remainderProductDto) {
        remainderProductService.updateRemainderProduct(remainderProductId, remainderProductDto);
    }

    @DeleteMapping(value = "/{remainderProductId}")
    void deleteRemainderProduct(@PathVariable String remainderProductId) {
        remainderProductService.deleteRemainderProduct(remainderProductId);
    }

}
