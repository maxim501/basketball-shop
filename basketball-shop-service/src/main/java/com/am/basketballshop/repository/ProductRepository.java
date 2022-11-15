package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("select p from prd$product p where p.subSection.id=:subSectionId")
    List<Product> productsBySubSection(String subSectionId);
}
