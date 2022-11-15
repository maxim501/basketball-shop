package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.CompanyDto;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketballshop.model.product.Company;
import com.am.basketballshop.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());

        Company saveCompany = companyRepository.save(company);

        return CompanyDto.builder()
                .id(saveCompany.getId())
                .name(saveCompany.getName())
                .build();
    }

    public CompanyDto getCompany(String companyId) {
        Optional<Company> companyById = companyRepository.findById(companyId);
        Company company = companyById.orElseThrow(() -> {
            throw new NotFoundException("Not found company by id = " + companyId);
        });

        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }

    public void updateCompany(String companyId, CompanyDto companyDto) {
        Optional<Company> companyById = companyRepository.findById(companyId);
        Company company = companyById.orElseThrow(() -> {
            throw new NotFoundException("Not found company by id = " + companyId);
        });
        company.setName(companyDto.getName());

        Company updateCompany = companyRepository.save(company);
    }

    public void deleteCompany(String companyId) {
        Optional<Company> companyById = companyRepository.findById(companyId);
        Company company = companyById.orElseThrow(() -> {
            throw new NotFoundException("Not found company by id = " + companyId);
        });

        companyRepository.delete(company);
    }

}
