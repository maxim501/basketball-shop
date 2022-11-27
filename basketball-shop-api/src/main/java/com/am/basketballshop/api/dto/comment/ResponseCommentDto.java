package com.am.basketballshop.api.dto.comment;

import com.am.basketballshop.api.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCommentDto {

    private String id;
    private String massage;
    private Date createTs;
    private UserDto userDto;
}
