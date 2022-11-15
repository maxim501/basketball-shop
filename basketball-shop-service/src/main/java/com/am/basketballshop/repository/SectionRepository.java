package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, String> {
}
