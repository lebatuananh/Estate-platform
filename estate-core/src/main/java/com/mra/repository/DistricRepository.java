package com.mra.repository;

import com.mra.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistricRepository extends JpaRepository<DistrictEntity,Long> {
    DistrictEntity findOneByCode(String code);
}
