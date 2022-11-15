package com.am.basketballshop.controller;

import com.am.basketballshop.api.CompanyEndpoint;
import com.am.basketballshop.api.dto.CompanyDto;
import com.am.basketballshop.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController implements CompanyEndpoint {

    private final CompanyService companyService;

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        return companyService.createCompany(companyDto);
    }

    @Override
    public CompanyDto getCompany(String companyId) {
        return companyService.getCompany(companyId);
    }

    @Override
    public void updateCompany(String companyId, CompanyDto companyDto) {
        companyService.updateCompany(companyId, companyDto);
    }

    @Override
    public void deleteCompany(String companyId) {
        companyService.deleteCompany(companyId);
    }
}
