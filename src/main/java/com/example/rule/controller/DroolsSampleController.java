package com.example.rule.controller;

import com.example.rule.model.*;
import com.example.rule.service.DroolsService;

import com.example.rule.service.ProductService;
import com.example.rule.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/promotion")
public class DroolsSampleController {

    @Autowired
    private DroolsService bankService;

    @Autowired
    private ProductService productService;


    @CrossOrigin
    @PostMapping("/suggest-promotion")
    public ResponseEntity<Response> getRate(@RequestBody RequestSP request) {
        Response response =  bankService.getSuggestPromotion(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        List<ProductDTO> response =  productService.getAllProduct();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
