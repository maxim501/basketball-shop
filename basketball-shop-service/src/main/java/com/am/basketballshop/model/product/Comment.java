package com.am.basketballshop.model.product;

import com.am.basketballshop.model.base.BasedNanoIdEntity;
import com.am.basketballshop.model.security.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
@Data
@Entity(name = "prd$comment")
@Table(name = "COMMENT")
public class Comment extends BasedNanoIdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "CREATE_TS")
    private Date createTs;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "USER_ID")
    private User user;

}
