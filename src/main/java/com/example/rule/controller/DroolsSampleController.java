package com.example.rule.controller;

import com.example.rule.model.CartItem;
import com.example.rule.model.Participant;
import com.example.rule.model.Promotion;
import com.example.rule.model.Rate;
import com.example.rule.service.DroolsService;

import java.util.List;
import java.util.Map;

import org.kie.api.definition.rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/bankservice")
public class DroolsSampleController {

    @Autowired
    private DroolsService bankService;

    @PostMapping("/getrate")
    public ResponseEntity<List<?>> getRate(@RequestBody CartItem request) {
        List<?> response = bankService.getRate(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
