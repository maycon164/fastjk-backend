package com.deadlock.fastjk.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "location")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationEntity {

    @Id
    private Long id;
    private String name;
    private String address;

}
