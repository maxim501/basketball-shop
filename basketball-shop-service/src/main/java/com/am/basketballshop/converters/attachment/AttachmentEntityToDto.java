package com.am.basketballshop.converters.attachment;

import com.am.basketballshop.api.dto.attachments.ResponseAttachmentDto;
import com.am.basketballshop.model.product.Attachment;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttachmentEntityToDto implements Converter<Attachment, ResponseAttachmentDto> {
    @Override
    public ResponseAttachmentDto convert(Attachment source) {
        return ResponseAttachmentDto.builder()
                .id(source.getId())
                .uploadDate(source.getUploadDate())
                .isPreviewImage(source.isPreviewImage())
                .extension(source.getExtension())
                .size(source.getSize())
                .downloadLink(source.getDownloadLink())
                .build();
    }
}
