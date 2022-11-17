package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.comment.RequestCommentDto;
import com.am.basketballshop.api.dto.comment.ResponseCommentDto;
import com.am.basketballshop.converters.base.UniversalConverter;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketballshop.model.product.Comment;
import com.am.basketballshop.model.product.Product;
import com.am.basketballshop.model.security.User;
import com.am.basketballshop.repository.CommentRepository;
import com.am.basketballshop.repository.ProductRepository;
import com.am.basketballshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    private final UniversalConverter converter;

    public ResponseCommentDto createComment(RequestCommentDto commentDto) {
        Comment comment = new Comment();
        comment.setMessage(commentDto.getMassage());
        comment.setCreateTs(new Date(new java.util.Date().getTime()));

        String productId = commentDto.getProductId();
        String userId = commentDto.getUserId();

        if (productId != null) {
            Optional<Product> productById = productRepository.findById(productId);
            Product product = productById.orElseThrow(() -> {
                throw new NotFoundException("Not found product by id = " + productId);
            });
            comment.setProduct(product);
        }

        if (userId != null) {
            Optional<User> userById = userRepository.findById(userId);
            User user = userById.orElseThrow(() -> {
                throw new NotFoundException("Not found user by id = " + userId);
            });
            comment.setUser(user);
        }

        Comment saveComment = commentRepository.save(comment);

        return converter.entityToDto(saveComment, ResponseCommentDto.class);
    }

}
