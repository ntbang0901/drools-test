package com.example.rule.service.Impl;

import com.example.rule.entity.ManufacturerEntity;
import com.example.rule.repository.ManufacturerRepository;
import com.example.rule.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ManufaceturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    List<String> listManufacturer = Arrays.asList("Samsung", "Apple", "Oppo", "Xiaomi", "Realme", "NOKIA", "Mobell", "Vivo",
            "HP","ASUS","Acer","Lenovo","DELL","MSI","GIGABYTE","LG");
    @Override
    public void insertData() {
        for(int i = 1; i <= listManufacturer.size() ; i++ ){
            ManufacturerEntity manufacturerEntity = new ManufacturerEntity();
            UUID uuid = UUID.randomUUID();
//           productEntity.setProductId(uuid.toString());
            manufacturerEntity.setManufacturerId(uuid);
            manufacturerEntity.setManufacturerName(listManufacturer.get(i-1));
            manufacturerRepository.save(manufacturerEntity);
        }
    }
}
