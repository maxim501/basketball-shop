package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.ProductModelDto;
import com.am.basketballshop.api.dto.product.RequestProductDto;
import com.am.basketballshop.api.dto.product.ResponseProductDto;
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

    private final RemainderProductRepository remainderProductRepository;
    private final VendorCodeGenerator vendorCodeGenerator;

    public ResponseProductDto createProduct(@RequestBody RequestProductDto productDto) {
        Product product = new Product();
        setProduct(product, productDto);

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


    public List<ResponseProductDto> getBySubSection(String subSectionId) {
        SubSection subSectionById = subSectionRepository.findById(subSectionId).orElseThrow(() -> {
            throw new NotFoundException("Not found subSection by id = " + subSectionId);
        });

        List<Product> productsBySubSectionId = productRepository.productsBySubSection(subSectionId);

        return convertProductsListToResponse(productsBySubSectionId);

    }

    public List<ProductModelDto> getRemainderProductModel(String productId) {
        Product productById = productRepository.findById(productId).orElseThrow(() -> {
            throw new NotFoundException("Not found product by id = " + productId);
        });

        Set<ProductModel> allProductModelById = productModelRepository.findByProductId(productId);
        Set<ProductModel> allProductModelByResponse = allProductModelById;

        return allProductModelByResponse.stream().map(ProductModel -> ProductModelDto.builder()
                .id(ProductModel.getId())
                .code(ProductModel.getCode())
                .name(ProductModel.getName())
                .remainderProductList(remainderProductRepository.findByProductModelId(ProductModel.getId())
                        .stream().collect(Collectors.toList()))
                .build()).collect(Collectors.toList());
    }

    public void updateProduct(String productId, RequestProductDto productDto) {
        Optional<Product> productById = productRepository.findById(productId);
        Product product = productById.orElseThrow(() -> {
            throw new NotFoundException("Not found product by id = " + productId);
        });
        setProduct(product, productDto);

        Product updateProduct = productRepository.save(product);
    }

    public void deleteProduct(String productId) {
        Optional<Product> productById = productRepository.findById(productId);
        Product product = productById.orElseThrow(() -> {
            throw new NotFoundException("Not found product by id = " + productId);
        });

        productRepository.delete(product);
    }

    public void setProduct(Product product, RequestProductDto productDto) {
        product.setNameModel(productDto.getNameModel());
        product.setNovelty(productDto.getNovelty());
        product.setSumma(productDto.getSumma());

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
    }

    private ResponseProductDto convertProductToResponse(Product product) {
        return ResponseProductDto.builder()
                .id(product.getId())
                .company(product.getCompany())
                .nameModel(product.getNameModel())
                .novelty(product.getNovelty())
                .summa(product.getSumma())
                .vendorCode(product.getVendorCode())
                .productModels(convertProductModelToDto(product.getProductModels()))
                .description(product.getDescription())
                .subSection(product.getSubSection())
                .build();
    }

    private List<ProductModelDto> convertProductModelToDto(List<ProductModel> productModels) {
        return productModels.stream().map(productModel -> ProductModelDto.builder()
                .id(productModel.getId())
                .code(productModel.getCode())
                .name(productModel.getName())
                .build()).collect(Collectors.toList());
    }

    private List<ResponseProductDto> convertProductsListToResponse(List<Product> products) {
        return products.stream().map(product -> ResponseProductDto.builder()
                .id(product.getId())
                .company(product.getCompany())
                .nameModel(product.getNameModel())
                .novelty(product.getNovelty())
                .summa(product.getSumma())
                .vendorCode(product.getVendorCode())
                .productModels(convertProductModelToDto(product.getProductModels()))
                .description(product.getDescription())
                .subSection(product.getSubSection())
                .build()).collect(Collectors.toList());
    }
}
