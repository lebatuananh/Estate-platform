package com.mra.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "district")
public class DistrictEntity extends BaseEntity {
    private static final long serialVersionUID = 1213459064882810867L;
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
