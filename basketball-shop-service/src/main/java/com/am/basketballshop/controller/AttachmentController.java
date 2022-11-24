package com.am.basketballshop.controller;

import com.am.basketballshop.api.AttachmentEndpoint;
import com.am.basketballshop.api.dto.attachments.RequestAttachmentDto;
import com.am.basketballshop.api.dto.attachments.ResponseAttachmentDto;
import com.am.basketballshop.services.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attachments")
public class AttachmentController implements AttachmentEndpoint {

    private final AttachmentService attachmentService;


    @Override
    public ResponseAttachmentDto createAttachment(RequestAttachmentDto attachmentDto) {
        try {
            return attachmentService.createAttachment(attachmentDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseAttachmentDto getAttachment(String attachmentId) {
        return attachmentService.getAttachment(attachmentId);
    }
}
