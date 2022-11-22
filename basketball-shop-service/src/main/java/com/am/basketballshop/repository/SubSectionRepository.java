package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.SubSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface SubSectionRepository extends JpaRepository<SubSection, String> {

    @Query("select s from prd$SubSection s where s.section.id = :sectionId")
    Set<SubSection> findBySectionId(@Param("sectionId") String sectionId);
}
