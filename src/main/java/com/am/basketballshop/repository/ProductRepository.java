package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
