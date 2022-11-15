package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.SizeDto;
import org.springframework.web.bind.annotation.*;

public interface SizeEndpoint {

    @PostMapping(value = "/")
    SizeDto createSize(@RequestBody SizeDto sizeDto);

    @PutMapping(value = "/{sizeId}")
    void updateSize(@PathVariable String sizeId, @RequestBody SizeDto sizeDto);

    @DeleteMapping(value = "/{sizeId}")
    void deleteSize(@PathVariable String sizeId);
}
