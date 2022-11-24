package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}
