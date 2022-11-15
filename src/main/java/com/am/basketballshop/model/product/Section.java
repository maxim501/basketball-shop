package com.am.basketballshop.model.product;

import com.am.basketballshop.model.base.BasedNanoIdEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "prd$section")
//подчеркивание, потому что SECTION служебное слово в бд
@Table(name = "_SECTION")
public class Section extends BasedNanoIdEntity {

    @Column(name = "NAME")
    private String name;
}
