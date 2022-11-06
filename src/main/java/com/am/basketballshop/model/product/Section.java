package com.am.basketballshop.model.product;

import com.am.basketballshop.model.base.BasedNanoIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "prd$section")
//подчеркивание, потому что SECTION служебное слово в бд
@Table(name = "_SECTION")
public class Section extends BasedNanoIdEntity {

    @Column(name = "NAME")
    private String name;
}
