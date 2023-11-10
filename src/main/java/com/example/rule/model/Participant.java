package com.example.rule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Participant {
    private int id;
    private String name;
    private int age;
    private int creditScore;
    private int quantity;
    private long annualSalary;
    private long existingDebt;
    private long loanAmount;
}
