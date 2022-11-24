package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.attachments.RequestAttachmentDto;
import com.am.basketballshop.api.dto.attachments.ResponseAttachmentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AttachmentEndpoint {

    @PostMapping(value = "/")
    ResponseAttachmentDto createAttachment(@RequestBody RequestAttachmentDto attachmentDto);

    @GetMapping(value = "/{attachmentId}")
    ResponseAttachmentDto getAttachment(@PathVariable String attachmentId);

}
