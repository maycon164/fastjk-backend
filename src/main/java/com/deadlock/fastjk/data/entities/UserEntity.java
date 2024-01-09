package com.deadlock.fastjk.data.entities;

import com.deadlock.fastjk.core.model.enums.TypeAccess;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity(name = "users")
public class UserEntity {

    @Id
    private Long id;
    private String name;
    private String email;
    @Transient
    private String photo;

    @Column(name = "type_access")
    private TypeAccess typeAccess;


}
