package com.am.basketballshop.converters.base;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniversalConverter {

    private final ConversionService conversionService;

    public <T, K> K entityToDto(T source, Class<K> _class) {
        return conversionService.convert(source, _class);
    }

    public <T, K> T dtoToEntity(K source, Class<T> _class) {
        return conversionService.convert(source, _class);
    }
}
