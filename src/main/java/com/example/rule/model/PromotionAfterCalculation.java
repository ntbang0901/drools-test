package com.example.rule.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionAfterCalculation  extends  Promotion{
    private Double result;
    private Double tienmuathem;
    private Integer soLuongMuaThem;
}
