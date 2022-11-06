package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, String> {
}
