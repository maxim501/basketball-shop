package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.ColorDto;
import com.am.basketballshop.api.dto.product.RequestProductDto;
import com.am.basketballshop.api.dto.product.ResponseProductDto;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketballshop.model.product.Color;
import com.am.basketballshop.model.product.Company;
import com.am.basketballshop.model.product.Product;
import com.am.basketballshop.model.product.SubSection;
import com.am.basketballshop.repository.ColorRepository;
import com.am.basketballshop.repository.CompanyRepository;
import com.am.basketballshop.repository.ProductRepository;
import com.am.basketballshop.repository.SubSectionRepository;
import com.am.basketballshop.utils.VendorCodeGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final CompanyRepository companyRepository;
    private final ColorRepository colorRepository;
    private final SubSectionRepository subSectionRepository;
    private final VendorCodeGenerator vendorCodeGenerator;

    public ResponseProductDto createProduct(@RequestBody RequestProductDto productDto) {
        Product product = new Product();
        product.setNameModel(productDto.getNameModel());
        product.setNovelty(productDto.getNovelty());
        product.setSum(productDto.getSum());

        product.setVendorCode(vendorCodeGenerator.generateVendorCode());

        product.setDescription(productDto.getDescription());

        String companyId = productDto.getCompanyId();
        String subSectionId = productDto.getSubSectionId();

        if (companyId != null) {
            Optional<Company> companyById = companyRepository.findById(companyId);
            Company company = companyById.orElseThrow(() -> {
                throw new NotFoundException("Not found company by id = " + companyId);
            });
            product.setCompany(company);
        }

        if (subSectionId != null) {
            Optional<SubSection> subSectionById = subSectionRepository.findById(subSectionId);
            SubSection subSection = subSectionById.orElseThrow(() -> {
                throw new NotFoundException("Not found subSection by id = " + subSectionById);
            });
            product.setSubSection(subSection);
        }

        List<ColorDto> colorDtoList = productDto.getColors();
        if (CollectionUtils.isNotEmpty(colorDtoList)) {
            List<Color> colors = colorDtoList.stream().map(colorDto -> {
                Color color = new Color();
                color.setName(colorDto.getName());
                color.setCode(colorDto.getCode());
                color.setProduct(product);
                return color;
            }).collect(Collectors.toList());
            product.setColors(colors);
        }

        Product saveProduct = productRepository.save(product);

        return convertProductToResponse(saveProduct);
    }

    public ResponseProductDto getProduct(String productId) {
        Optional<Product> productById = productRepository.findById(productId);
        Product product = productById.orElseThrow(() -> {
            throw new NotFoundException("Not found product by id = " + productId);
        });

        return convertProductToResponse(product);
    }


    public List<ResponseProductDto> getBySubSection(String subSectionId){
        SubSection subSectionById =subSectionRepository.findById(subSectionId).orElseThrow(() -> {
            throw new NotFoundException("Not found subSection by id = " + subSectionId);
        });

        List<Product> productsBySubSectionId = productRepository.findAll()
                .stream().filter(product -> product.getSubSection().getId()
                        .equals(subSectionId)).collect(Collectors.toList());

        return convertProductsListToResponse(productsBySubSectionId);

    }

    private ResponseProductDto convertProductToResponse(Product product) {
        return ResponseProductDto.builder()
                .id(product.getId())
                .company(product.getCompany())
                .nameModel(product.getNameModel())
                .novelty(product.getNovelty())
                .sum(product.getSum())
                .vendorCode(product.getVendorCode())
                .colors(convertColorModelToDto(product.getColors()))
                .description(product.getDescription())
                .subSection(product.getSubSection())
                .build();
    }

    private List<ColorDto> convertColorModelToDto(List<Color> colors) {
        return colors.stream().map(color -> ColorDto.builder()
                .id(color.getId())
                .code(color.getCode())
                .name(color.getName())
                .build()).collect(Collectors.toList());
    }

    private List<ResponseProductDto> convertProductsListToResponse(List<Product> products){
        return products.stream().map(product -> ResponseProductDto.builder()
                .id(product.getId())
                .company(product.getCompany())
                .nameModel(product.getNameModel())
                .novelty(product.getNovelty())
                .sum(product.getSum())
                .vendorCode(product.getVendorCode())
                .colors(convertColorModelToDto(product.getColors()))
                .description(product.getDescription())
                .subSection(product.getSubSection())
                .build()).collect(Collectors.toList());
    }
}
