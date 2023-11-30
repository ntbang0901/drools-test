package com.example.rule.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private int totalQuantity;
    private double totalPrice;
    List<ProductCart> products  = new ArrayList<>();
    // getters and setters


}