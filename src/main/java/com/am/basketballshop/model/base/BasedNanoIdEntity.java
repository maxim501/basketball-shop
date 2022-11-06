package com.am.basketballshop.model.base;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
@Getter
public class BasedNanoIdEntity {

    @Id
    @Column(name = "ID")
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public BasedNanoIdEntity() {
        this.id = NanoIdUtils.randomNanoId();
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        return Objects.equals(getId(), ((BasedNanoIdEntity) obj).getId());
    }
}
