package com.deadlock.fastjk.data.entities;

import com.deadlock.fastjk.core.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    private Long id;
    private String name;
    private String email;
    @Transient
    private String photo;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_access")
    private Role typeAccess;
}
