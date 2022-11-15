package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.RemainderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RemainderProductRepository extends JpaRepository<RemainderProduct, String> {

    @Query("select c from prd$RemainderProduct c where c.productModel.id=:productModelId")
    Set<RemainderProduct> findByProductModelId(String productModelId);
}
