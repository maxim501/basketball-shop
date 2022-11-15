package com.am.basketballshop.converters.size;

import com.am.basketballshop.model.product.Size;
import com.am.basketbalshop.api.dto.SizeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SizeDtoToEntity implements Converter<SizeDto, Size> {

    @Override
    public Size convert(SizeDto source) {
        Size size = new Size();

        if (source.getId() != null) {
            size.setId(source.getId());
        }

        size.setCode(source.getCode());
        size.setName(source.getName());
        return size;
    }
}
