package com.am.basketballshop.model.security;

import com.am.basketballshop.model.base.BasedNanoIdEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "sec$user")
@Table(name = "_USER")
public class User extends BasedNanoIdEntity {
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADMIN")
    private Boolean admin;
}
