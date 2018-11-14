package com.mra.repository;

import com.mra.entity.BuildingEntity;
import com.mra.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
    Page<BuildingEntity> findAll(Pageable pageable);
}
