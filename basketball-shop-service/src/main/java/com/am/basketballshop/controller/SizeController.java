package com.am.basketballshop.controller;

import com.am.basketballshop.api.SizeEndpoint;
import com.am.basketballshop.api.dto.SizeDto;
import com.am.basketballshop.services.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/size")
public class SizeController implements SizeEndpoint {

    private final SizeService sizeService;

    @Override
    public List<SizeDto> getAllSizes() {
        return sizeService.getAllSizes();
    }

    @Override
    public SizeDto getSize(String sizeId) {
        return sizeService.getSize(sizeId);
    }

    @Override
    public SizeDto createSize(SizeDto sizeDto) {
        return sizeService.createSize(sizeDto);
    }

    @Override
    public SizeDto updateSize(String sizeId, SizeDto sizeDto) {
        return sizeService.updateSize(sizeId, sizeDto);
    }

    @Override
    public void deleteSize(String sizeId) {
        sizeService.deleteSize(sizeId);
    }

}
