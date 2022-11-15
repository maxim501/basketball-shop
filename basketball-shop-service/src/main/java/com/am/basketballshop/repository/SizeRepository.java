package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size,String> {
}
