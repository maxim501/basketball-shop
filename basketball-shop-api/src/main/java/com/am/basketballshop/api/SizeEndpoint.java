package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.SizeDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SizeEndpoint {

    @GetMapping(value = "/all")
    List<SizeDto> getAllSizes();

    @GetMapping(value = "/{sizeId}")
    SizeDto getSize(@PathVariable String sizeId);

    @PostMapping(value = "/")
    SizeDto createSize(@RequestBody SizeDto sizeDto);

    @PutMapping(value = "/{sizeId}")
    SizeDto updateSize(@PathVariable String sizeId, @RequestBody SizeDto sizeDto);

    @DeleteMapping(value = "/{sizeId}")
    void deleteSize(@PathVariable String sizeId);
}
