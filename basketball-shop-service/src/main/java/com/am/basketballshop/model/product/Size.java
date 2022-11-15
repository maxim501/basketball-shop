package com.am.basketballshop.model.product;

import com.am.basketballshop.model.base.BasedNanoIdEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "prd@size")
@Table(name = "SIZE")
public class Size extends BasedNanoIdEntity {

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;
}
