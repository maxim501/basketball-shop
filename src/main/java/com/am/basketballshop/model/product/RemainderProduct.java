package com.am.basketballshop.model.product;

import com.am.basketballshop.model.base.BasedNanoIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity(name = "prd$RemainderProduct")
@Table(name = "REMAINDER_PRODUCT")
public class RemainderProduct extends BasedNanoIdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "PRODUCT_MODEL_ID")
    private ProductModel productModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "SIZE_ID")
    private Size size;

    @Column(name = "REMAINDER")
    private String remainder;
}
