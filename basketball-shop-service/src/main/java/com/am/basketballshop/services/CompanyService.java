package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.CompanyDto;
import com.am.basketballshop.converters.base.UniversalConverter;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketballshop.model.product.Company;
import com.am.basketballshop.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UniversalConverter converter;

    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(c -> converter.entityToDto(c, CompanyDto.class))
                .collect(Collectors.toList());
    }

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

    public CompanyDto updateCompany(String companyId, CompanyDto companyDto) {
        Optional<Company> companyById = companyRepository.findById(companyId);
        Company company = companyById.orElseThrow(() -> {
            throw new NotFoundException("Not found company by id = " + companyId);
        });
        company.setName(companyDto.getName());

        Company updateCompany = companyRepository.save(company);

        return converter.entityToDto(updateCompany, CompanyDto.class);
    }

    public void deleteCompany(String companyId) {
        Optional<Company> companyById = companyRepository.findById(companyId);
        Company company = companyById.orElseThrow(() -> {
            throw new NotFoundException("Not found company by id = " + companyId);
        });

        companyRepository.delete(company);
    }

}
