package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.CompanyDto;
import com.am.basketballshop.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping(value = "/")
    CompanyDto createCompany(@RequestBody CompanyDto companyDto) {
        return companyService.createCompany(companyDto);
    }

    @GetMapping(value = "/{companyId}")
    CompanyDto getCompany(@RequestBody String companyId) {
        return companyService.getCompany(companyId);
    }
}
