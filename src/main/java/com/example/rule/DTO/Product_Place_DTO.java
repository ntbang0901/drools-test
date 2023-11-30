package com.example.rule.DTO;

import com.example.rule.model.Place;
import com.example.rule.model.Product;
import lombok.Data;

@Data
public class Product_Place_DTO {
    private Product product;
    private Place place;
}
