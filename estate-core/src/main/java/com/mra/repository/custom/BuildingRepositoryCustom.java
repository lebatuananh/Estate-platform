package com.mra.repository.custom;

import com.mra.entity.BuildingEntity;
import com.mra.repository.paging.Pageable;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(Pageable pageable);
    Long getTotalItems();
}
