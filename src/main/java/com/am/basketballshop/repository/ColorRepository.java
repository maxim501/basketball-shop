package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ColorRepository extends JpaRepository<Color, String> {

    //здесь в запросе используется не sql а специальный язык jpql для запросов при помощи jpa (например хибернейт)
    @Query("select с from Color c where c.product.id = :productId")
    Set<Color> findByProductId(@Param("productId") String productId);

}
