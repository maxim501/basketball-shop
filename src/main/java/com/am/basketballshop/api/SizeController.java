package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.SizeDto;
import com.am.basketballshop.services.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/size")
public class SizeController {

    private final SizeService sizeService;

    @PostMapping(value = "/")
    SizeDto createSize(@RequestBody SizeDto sizeDto){
        return sizeService.createSize(sizeDto);
    }

}
