package com.example.rule.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private List<PromotionAfterCalculation> cartPromotion ;
    private List<PromotionAfterCalculation> itemPromotion ;

}
