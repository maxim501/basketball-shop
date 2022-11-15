package com.am.basketballshop.controller;

import com.am.basketballshop.api.SizeEndpoint;
import com.am.basketballshop.api.dto.SizeDto;
import com.am.basketballshop.services.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/size")
public class SizeController implements SizeEndpoint {

    private final SizeService sizeService;

    @Override
    public SizeDto createSize(SizeDto sizeDto) {
        return sizeService.createSize(sizeDto);
    }

    @Override
    public void updateSize(String sizeId, SizeDto sizeDto) {
        sizeService.updateSize(sizeId, sizeDto);
    }

    @Override
    public void deleteSize(String sizeId) {
        sizeService.deleteSize(sizeId);
    }

}
