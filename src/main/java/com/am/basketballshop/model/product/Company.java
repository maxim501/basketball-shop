package com.am.basketballshop.model.product;

import com.am.basketballshop.model.base.BasedNanoIdEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "prd$company")
@Table(name = "COMPANY")
public class Company extends BasedNanoIdEntity {

    @Column(name = "NAME")
    private String name;

}
