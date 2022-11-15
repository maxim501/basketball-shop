package com.am.basketballshop.services;

import com.am.basketballshop.converters.base.UniversalConverter;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketballshop.model.product.Company;
import com.am.basketballshop.repository.CompanyRepository;
import com.am.basketballshop.api.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UniversalConverter converter;

    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = converter.dtoToEntity(companyDto, Company.class);

        Company saveCompany = companyRepository.save(company);

        return converter.entityToDto(saveCompany, CompanyDto.class);
    }

    public CompanyDto getCompany(String companyId) {
        Optional<Company> companyById = companyRepository.findById(companyId);
        Company company = companyById.orElseThrow(() -> {
            throw new NotFoundException("Not found company by id = " + companyId);
        });

        return converter.entityToDto(company, CompanyDto.class);
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
