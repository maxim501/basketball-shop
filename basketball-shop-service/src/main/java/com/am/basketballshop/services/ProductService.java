package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.ProductModelDto;
import com.am.basketballshop.api.dto.product.ProductDto;
import com.am.basketballshop.api.dto.remainderProduct.RemainderProductDto;
import com.am.basketballshop.converters.base.UniversalConverter;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketballshop.model.product.Company;
import com.am.basketballshop.model.product.Product;
import com.am.basketballshop.model.product.ProductModel;
import com.am.basketballshop.model.product.SubSection;
import com.am.basketballshop.repository.*;
import com.am.basketballshop.utils.VendorCodeGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final CompanyRepository companyRepository;
    private final ProductModelRepository productModelRepository;
    private final SubSectionRepository subSectionRepository;

    private final UniversalConverter converter;

    private final RemainderProductRepository remainderProductRepository;
    private final VendorCodeGenerator vendorCodeGenerator;

    public ProductModelDto getProductModel(String productModelId) {
        Optional<ProductModel> productModelById = productModelRepository.findById(productModelId);
        ProductModel productModel = productModelById.orElseThrow(() -> {
            throw new NotFoundException("Not found product model by id = " + productModelId);
        });
        System.out.println();
        System.out.println(converter.entityToDto(productModel, ProductModelDto.class));
        System.out.println();

        return converter.entityToDto(productModel, ProductModelDto.class);
//        return ProductModelDto.builder()
//                .id(productModel.getId())
//                .name(productModel.getName())
//                .code(productModel.getCode())
//                .remainderProductList(remainderProductRepository.findByProductModelId(productModel.getId()).stream().
//                        map(remainderProduct -> {
//                    RemainderProductDto
//                            .builder()
//                            .id(remainderProduct.getId())
//                            .productModelId(remainderProduct.getId())
//                            .remainder(remainderProduct.getRemainder())
//                            .build();
//                }).collect(Collectors.toList())
//                .build();
    }

    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();

        product.setNameModel(productDto.getNameModel());
        product.setNovelty(productDto.getNovelty());
        product.setSumma(productDto.getSumma());
        product.setVendorCode(vendorCodeGenerator.generateVendorCode());
        product.setDescription(productDto.getDescription());

        String companyId = productDto.getCompany() != null ? productDto.getCompany().getId() : null;
        String subSectionId = productDto.getSubSection() != null ? productDto.getSubSection().getId() : null;

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

        List<ProductModelDto> productModelDtoList = productDto.getProductModels();
        if (CollectionUtils.isNotEmpty(productModelDtoList)) {
            List<ProductModel> productModels = productModelDtoList.stream().map(productModelDto -> {
                ProductModel productModel = new ProductModel();
                productModel.setName(productModelDto.getName());
                productModel.setCode(productModelDto.getCode());
                productModel.setProduct(product);
                return productModel;
            }).collect(Collectors.toList());
            product.setProductModels(productModels);
        }

        Product saveProduct = productRepository.save(product);

        return converter.entityToDto(saveProduct, ProductDto.class);
    }

    public ProductDto getProduct(String productId) {
        Optional<Product> productById = productRepository.findById(productId);
        Product product = productById.orElseThrow(() -> {
            throw new NotFoundException("Not found product by id = " + productId);
        });

        return converter.entityToDto(product, ProductDto.class);
    }


    public List<ProductDto> getBySubSection(String subSectionId) {
        List<Product> productsBySubSectionId = productRepository.productsBySubSection(subSectionId);

        return productsBySubSectionId.stream()
                .map(product ->
                        converter.entityToDto(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public List<ProductModelDto> getRemainderProductModel(String productId) {
        Set<ProductModel> allProductModelById = productModelRepository.findByProductId(productId);

        return allProductModelById.stream()
                .map(productModel -> {
                    ProductModelDto productModelDto = converter.entityToDto(productModel, ProductModelDto.class);
                    productModelDto.setRemainderProductList(
                            remainderProductRepository.findByProductModelId(productModel.getId()).stream()
                                    .map(remainderProduct -> converter.entityToDto(remainderProduct, RemainderProductDto.class))
                                    .collect(Collectors.toList()));
                    return productModelDto;
                })
                .collect(Collectors.toList());
    }

    public ProductDto updateProduct(String productId, ProductDto productDto) {
        Optional<Product> productById = productRepository.findById(productId);
        Product product = productById.orElseThrow(() -> {
            throw new NotFoundException("Not found product by id = " + productId);
        });
        product.setNameModel(productDto.getNameModel());
        product.setNovelty(productDto.getNovelty());
        product.setSumma(productDto.getSumma());
        product.setDescription(productDto.getDescription());

        String companyId = productDto.getCompany() != null ? productDto.getCompany().getId() : null;
        String subSectionId = productDto.getSubSection() != null ? productDto.getSubSection().getId() : null;

        if (companyId != null) {
            Optional<Company> companyById = companyRepository.findById(companyId);
            Company company = companyById.orElseThrow(() -> {
                throw new NotFoundException("Not found company by id = " + companyId);
            });
            product.setCompany(company);
        } else {
            product.setCompany(null);
        }

        if (subSectionId != null) {
            Optional<SubSection> subSectionById = subSectionRepository.findById(subSectionId);
            SubSection subSection = subSectionById.orElseThrow(() -> {
                throw new NotFoundException("Not found subSection by id = " + subSectionById);
            });
            product.setSubSection(subSection);
        }

        List<ProductModelDto> productModelDtoList = productDto.getProductModels();
        if (CollectionUtils.isEmpty(productModelDtoList)) {
            productDto.setProductModels(new ArrayList<>());
        } else {
            List<ProductModel> productModels = productModelDtoList.stream().map(productModelDto -> {
                ProductModel productModel = converter.dtoToEntity(productModelDto, ProductModel.class);
                productModel.setProduct(product);
                return productModel;
            }).collect(Collectors.toList());
            product.setProductModels(productModels);
        }

        Product updateProduct = productRepository.save(product);

        return converter.entityToDto(updateProduct, ProductDto.class);
    }

    public void deleteProduct(String productId) {
        Optional<Product> productById = productRepository.findById(productId);
        Product product = productById.orElseThrow(() -> {
            throw new NotFoundException("Not found product by id = " + productId);
        });

        productRepository.delete(product);
    }
}
