package com.am.basketballshop.model.product;

import com.am.basketballshop.model.base.BasedNanoIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Data
@Entity(name = "prd$ProductModel")
@Table(name = "PRODUCT_MODEL")
public class ProductModel extends BasedNanoIdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    public String getFullVendorCode() {
        if (product == null || StringUtils.isBlank(product.getVendorCode())) {
            return code;
        }

        return product.getVendorCode() + "-" + code;
    }

    //будет ссылка на папке с фотками, в созданном в будущем файловом хранилище
}
