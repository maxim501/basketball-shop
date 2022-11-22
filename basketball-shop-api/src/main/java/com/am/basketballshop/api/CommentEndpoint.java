package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.comment.RequestCommentDto;
import com.am.basketballshop.api.dto.comment.ResponseCommentDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommentEndpoint {

    @PostMapping(value = "/")
    ResponseCommentDto createComment(@RequestBody RequestCommentDto commentDto);
}