package com.mra.controller.api;

import com.mra.dto.BuildingDTO;
import com.mra.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/building")
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;

    @PostMapping
    public ResponseEntity<BuildingDTO> createNew(@RequestBody BuildingDTO dto) {
        return ResponseEntity.ok(buildingService.save(dto));
    }

    @PutMapping
    public ResponseEntity<BuildingDTO> updateNew(@RequestBody BuildingDTO updateNew) {
        return ResponseEntity.ok(buildingService.update(updateNew));
    }
}
