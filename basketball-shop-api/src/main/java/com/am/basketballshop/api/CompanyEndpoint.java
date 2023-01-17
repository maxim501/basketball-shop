package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.CompanyDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CompanyEndpoint {

    @GetMapping(value = "/all")
    List<CompanyDto> getAllCompanies();

    @PostMapping(value = "/")
    CompanyDto createCompany(@RequestBody CompanyDto companyDto);

    @GetMapping(value = "/{companyId}")
    CompanyDto getCompany(@PathVariable String companyId);

    @PutMapping(value = "/{companyId}")
    CompanyDto updateCompany(@PathVariable String companyId, @RequestBody CompanyDto companyDto);

    @DeleteMapping(value = "/{companyId}")
    void deleteCompany(@PathVariable String companyId);
}
