package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.attachments.RequestAttachmentDto;
import com.am.basketballshop.api.dto.attachments.ResponseAttachmentDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentEndpoint {

    @PostMapping(value = "/",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseAttachmentDto createAttachment(RequestAttachmentDto attachmentDto, @RequestPart MultipartFile file);

    @GetMapping(value = "/{attachmentId}")
    ResponseAttachmentDto getAttachment(@PathVariable String attachmentId);

}
