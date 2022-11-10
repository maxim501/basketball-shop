package com.am.basketballshop.model.product;

import com.am.basketballshop.model.base.BasedNanoIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * базовый класс для всех товаров
 */
@Data
@Entity(name = "prd$product")
@Table(name = "PRODUCT")
public class Product extends BasedNanoIdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @Column(name = "NAME_MODEL")
    private String nameModel;

    @Column(name = "NOVELTY")
    private Boolean novelty;

    @Column(name = "VENDOR_CODE")
    private String vendorCode;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProductModel> productModels;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "SUB_SECTION_ID")
    private SubSection subSection;

    @Column(name = "SUMMA")
    private Integer summa;
}
