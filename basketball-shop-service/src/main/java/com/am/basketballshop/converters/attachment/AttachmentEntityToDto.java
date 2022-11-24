package com.am.basketballshop.converters.attachment;

import com.am.basketballshop.api.dto.attachments.ResponseAttachmentDto;
import com.am.basketballshop.model.product.Attachment;
import org.springframework.core.convert.converter.Converter;

public class AttachmentEntityToDto implements Converter<Attachment, ResponseAttachmentDto> {
    @Override
    public ResponseAttachmentDto convert(Attachment source) {
        return ResponseAttachmentDto.builder()
                .id(source.getId())
                .uploadDate(source.getUploadDate())
                .extension(source.getExtension())
                .size(source.getSize())
                .downloadLink(source.getDownloadLink())
                .build();
    }
}
