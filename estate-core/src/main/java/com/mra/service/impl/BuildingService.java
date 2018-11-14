package com.mra.service.impl;

import com.mra.converter.BuildingConverter;
import com.mra.dto.BuildingDTO;
import com.mra.entity.BuildingEntity;
import com.mra.repository.BuildingRepository;
import com.mra.repository.DistricRepository;
import com.mra.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingService implements IBuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private BuildingConverter buildingConverter;

    @Override
    public void findAll(BuildingDTO model, Pageable pageable) {
        List<BuildingEntity> builds = buildingRepository.findAll(pageable).getContent();
        model.setListResult(builds.stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList()));
        model.setTotalItem(buildingRepository.getTotalItems().intValue());
    }

    @Override
    public BuildingDTO save(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        buildingEntity = buildingRepository.save(buildingEntity);
        return buildingConverter.convertToDto(buildingEntity);
    }

    @Override
    public BuildingDTO update(BuildingDTO updateDTO) {
        BuildingEntity exitBuilding = buildingRepository.findOne(updateDTO.getId());
        BuildingEntity updateNew = buildingConverter.convertToEntity(updateDTO);
        updateNew.setCreatedBy(exitBuilding.getCreatedBy());
        updateNew.setCreatedDate(exitBuilding.getCreatedDate());
        exitBuilding = buildingRepository.save(updateNew);
        return buildingConverter.convertToDto(exitBuilding);
    }

    @Override
    public BuildingDTO findOneId(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findOne(id);
        return buildingConverter.convertToDto(buildingEntity);
    }
}
