package com.example.rule.service.Impl;

import com.example.rule.entity.RegionEntity;
import com.example.rule.model.Region;
import com.example.rule.repository.RegionRepository;
import com.example.rule.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionRepository regionRepository;

    List<String> listRegion = Arrays.asList("Bac", "Trung", "Nam","Tay Nam Bo");
    @Override
    public void insertData() {
        for(int i = 1; i <= listRegion.size() ; i++ ){
            RegionEntity regionEntity = new RegionEntity();
            UUID uuid = UUID.randomUUID();
//            productEntity.setProductId(uuid.toString());
            regionEntity.setRegionId(uuid);
            regionEntity.setRegionName(listRegion.get(i-1));

            regionRepository.save(regionEntity);
        }
    }
    @Override
    public List<Region> getAllRegion() {
        return null;
    }

    @Override
    public Region region(RegionEntity entity) {
        return null;
    }

    @Override
    public RegionEntity findById(String id) {
        return null;
    }
}
