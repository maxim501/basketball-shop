package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.CompanyDto;
import org.springframework.web.bind.annotation.*;

public interface CompanyEndpoint {

    @PostMapping(value = "/")
    CompanyDto createCompany(@RequestBody CompanyDto companyDto);

    @GetMapping(value = "/{companyId}")
    CompanyDto getCompany(@RequestBody String companyId);

    @PutMapping(value = "/{companyId}")
    void updateCompany(@PathVariable String companyId, @RequestBody CompanyDto companyDto);

    @DeleteMapping(value = "/{companyId}")
    void deleteCompany(@PathVariable String companyId);
}
