package com.example.rule.service;

import com.example.rule.entity.RegionEntity;
import com.example.rule.model.Region;

import java.util.List;

public interface RegionService {
    void insertData();

    List<Region> getAllRegion();

    Region region (RegionEntity entity);
    RegionEntity findById(String id);
}
