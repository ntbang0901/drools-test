package com.example.rule.controller;

import com.example.rule.service.CategoryService;
import com.example.rule.service.ManufacturerService;
import com.example.rule.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/insert-data")
public class InsertDataController {
    @Autowired
    private RegionService regionService;
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private CategoryService categoryService;

    @CrossOrigin
    @PostMapping("/manufacturer")
    public ResponseEntity<String> insertManufacturer() {
        manufacturerService.insertData();
        return new ResponseEntity<>("Insert successfully", HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/region")
    public ResponseEntity<String> insertRegion() {
        regionService.insertData();
        return new ResponseEntity<>("Insert successfully", HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/category")
    public ResponseEntity<String> insertCategory() {
        categoryService.insertData();
        return new ResponseEntity<>("Insert successfully", HttpStatus.OK);
    }
}
