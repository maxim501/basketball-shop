package com.am.basketballshop.converters.comment;

import com.am.basketballshop.api.dto.UserDto;
import com.am.basketballshop.api.dto.comment.ResponseCommentDto;
import com.am.basketballshop.model.product.Comment;
import com.am.basketballshop.model.security.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentEntityToDto implements Converter<Comment, ResponseCommentDto> {
    @Override
    public ResponseCommentDto convert(Comment source) {
        return ResponseCommentDto.builder()
                .id(source.getId())
                .massage(source.getMessage())
                .createTs(source.getCreateTs())
                .userDto(convert(source.getUser()))
                .build();
    }

    private UserDto convert(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
