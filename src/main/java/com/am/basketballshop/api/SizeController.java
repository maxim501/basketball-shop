package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.SizeDto;
import com.am.basketballshop.services.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/size")
public class SizeController {

    private final SizeService sizeService;

    @PostMapping(value = "/")
    SizeDto createSize(@RequestBody SizeDto sizeDto) {
        return sizeService.createSize(sizeDto);
    }

    @PutMapping(value = "/{sizeId}")
    void updateSize(@PathVariable String sizeId, @RequestBody SizeDto sizeDto) {
        sizeService.updateSize(sizeId, sizeDto);
    }

    @DeleteMapping(value = "/{sizeId}")
    void deleteSize(@PathVariable String sizeId) {
        sizeService.deleteSize(sizeId);
    }

}
