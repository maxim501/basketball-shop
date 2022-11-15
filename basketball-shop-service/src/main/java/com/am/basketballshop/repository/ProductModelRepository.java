package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ProductModelRepository extends JpaRepository<ProductModel, String> {

    //здесь в запросе используется не sql а специальный язык jpql для запросов при помощи jpa (например хибернейт)
    @Query("select c from prd$ProductModel c where c.product.id = :productId")
    Set<ProductModel> findByProductId(@Param("productId") String productId);

}
