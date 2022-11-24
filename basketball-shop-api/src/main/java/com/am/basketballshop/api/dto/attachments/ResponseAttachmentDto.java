package com.am.basketballshop.api.dto.attachments;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAttachmentDto {
    private String id;
    private LocalDate uploadDate;
    private String extension;
    private Long size;
    private String downloadLink;
}
