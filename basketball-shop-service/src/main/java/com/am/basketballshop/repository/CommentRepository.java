package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
}
