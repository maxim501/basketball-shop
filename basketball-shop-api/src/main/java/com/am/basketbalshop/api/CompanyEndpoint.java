package com.am.basketbalshop.api;

import com.am.basketbalshop.api.dto.CompanyDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CompanyEndpoint {

    @PostMapping(value = "/")
    CompanyDto createCompany(@RequestBody CompanyDto companyDto);

    @GetMapping(value = "/{companyId}")
    CompanyDto getCompany(@RequestBody String companyId);
}
