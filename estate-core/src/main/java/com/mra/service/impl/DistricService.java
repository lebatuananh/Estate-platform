package com.mra.service.impl;


import com.mra.repository.DistricRepository;
import com.mra.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DistricService implements IDistrictService {
    @Autowired
    private DistricRepository districRepository;

    @Override
    public Map<String, String> getDistrics() {
        Map<String, String> results = new HashMap<>();
        districRepository.findAll().forEach(item -> results.put(item.getCode(), item.getName()));
        return results;
    }
}
