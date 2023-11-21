package com.example.rule.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {
    private int id;
    private String productId;
    private int priceProduct;
    private String name;
    private String desc;
    private Date start;
    private Date end;
    private Integer value;
    private Double conditionTotalCart;
    private Integer conditionQuantity;
    private String type;

}
