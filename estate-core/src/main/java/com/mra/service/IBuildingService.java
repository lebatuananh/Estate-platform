package com.mra.service;

import com.mra.dto.BuildingDTO;
import org.springframework.data.domain.Pageable;

public interface IBuildingService {
    void findAll(BuildingDTO model, Pageable pageable);

    BuildingDTO save(BuildingDTO buildingDTO);

    BuildingDTO update(BuildingDTO buildingDTO);

    BuildingDTO findOneId(Long id);
}
