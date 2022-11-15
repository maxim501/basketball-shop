package com.am.basketballshop.repository;

import com.am.basketballshop.model.product.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
