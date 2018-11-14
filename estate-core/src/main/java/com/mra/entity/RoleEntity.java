package com.mra.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {
    private static final long serialVersionUID = -7651246623668177378L;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<UserEntity> users = new ArrayList<>();

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

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
