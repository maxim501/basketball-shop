package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.SizeDto;
import com.am.basketballshop.model.product.Size;
import com.am.basketballshop.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SizeService {

    private final SizeRepository sizeRepository;

    public SizeDto createSize(SizeDto sizeDto){
        Size size = new Size();
        size.setCode(sizeDto.getCode());
        size.setName(sizeDto.getName());

        Size saveSize = sizeRepository.save(size);

        return SizeDto.builder()
                .id(saveSize.getId())
                .code(saveSize.getCode())
                .name(saveSize.getName())
                .build();
    }
}
