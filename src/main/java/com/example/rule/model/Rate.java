package com.example.rule.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Rate {
    private String loanStatus;
    private double loanRate;
    private List<Promotion> listRules = new ArrayList<>();
    public void addPromotion(Promotion promotion) {
        if(!this.listRules.contains(promotion)){
            this.listRules.add(promotion);
        }
    }
}



