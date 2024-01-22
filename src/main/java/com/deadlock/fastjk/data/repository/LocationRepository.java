package com.deadlock.fastjk.data.repository;

import com.deadlock.fastjk.data.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
}
