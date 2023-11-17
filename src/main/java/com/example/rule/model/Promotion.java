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
    private int productId;
    private String name;
    private String desc;
    private Date start;
    private Date end;
    private Double value;
    private Double condition;
}
