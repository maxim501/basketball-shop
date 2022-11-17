package com.am.basketballshop.controller;

import com.am.basketballshop.api.CommentEndpoint;
import com.am.basketballshop.api.dto.comment.RequestCommentDto;
import com.am.basketballshop.api.dto.comment.ResponseCommentDto;
import com.am.basketballshop.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController implements CommentEndpoint {

    private final CommentService commentService;


    @Override
    public ResponseCommentDto createComment(RequestCommentDto commentDto) {
        return commentService.createComment(commentDto);
    }
}
