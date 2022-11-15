package com.am.basketballshop.controller;

import com.am.basketballshop.services.CompanyService;
import com.am.basketbalshop.api.CompanyEndpoint;
import com.am.basketbalshop.api.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController implements CompanyEndpoint {

    private final CompanyService companyService;

    @Override
    public CompanyDto createCompany(@RequestBody CompanyDto companyDto) {
        return companyService.createCompany(companyDto);
    }

    @Override
    CompanyDto getCompany(@PathVariable String companyId) {
        return companyService.getCompany(companyId);
    }

    @PutMapping(value = "/{companyId}")
    void updateCompany(@PathVariable String companyId, @RequestBody CompanyDto companyDto) {
        companyService.updateCompany(companyId, companyDto);
    }

    @DeleteMapping(value = "/{companyId}")
    void deleteCompany(@PathVariable String companyId) {
        companyService.deleteCompany(companyId);
    }
}
