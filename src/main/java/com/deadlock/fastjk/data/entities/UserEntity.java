package com.deadlock.fastjk.data.entities;

import com.deadlock.fastjk.core.model.enums.TypeAccess;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "users")
@Data
public class UserEntity {

    @Id
    private Long id;
    private String name;
    private String email;
    @Transient
    private String photo;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_access")
    private TypeAccess typeAccess;


}
