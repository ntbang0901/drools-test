package com.example.rule.service;

import com.example.rule.model.*;

import java.util.*;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroolsService {
    @Autowired
    private KieContainer kieContainer;

    public List<?> getRate(CartItem applicantRequest) {
        Rate rate = new Rate();


        List<Product> products = new ArrayList<>() {{
            add(new Product(1001,2,195000,"AAA"));
            add(new Product(1002,3,140000,"BBB"));

        }};
        CartItem item = new CartItem(10,155000,products);

        List<Promotion> promotions = new ArrayList<>() {{
            add(new Promotion(1, 1001, "Giảm giá 20%", "Giảm giá 20% cho sản phẩm A", new Date(1636760400000L), new Date(1640907600000L), 30000.0 , 219000.0));
            add(new Promotion(2, 1001, "Mua 1 tặng 1", "Mua 1 sản phẩm B, tặng 1 sản phẩm B miễn phí", new Date(1640994000000L), new Date(1643658000000L), 11500.0 ,115000.0 ));
            add(new Promotion(3, 1001, "Giảm giá 10%", "Giảm giá 10% cho sản phẩm C", new Date(1643658000000L), new Date(1646097600000L), 50000.0,159000.0));
            add(new Promotion(3, 1001, "Giảm giá 10%", "Giảm giá 10% cho sản phẩm C", new Date(1643658000000L), new Date(1646097600000L), 20000.0,199000.0));
        }};

        KieSession kieSession = kieContainer.newKieSession();
        //kieSession.setGlobal("rate", rate);
        //kieSession.insert(applicantRequest);
        kieSession.insert(applicantRequest);

        for (Product product : item.getProducts()) {
            kieSession.insert(product);
        }

        // Insert danh sách các khuyến mãi vào kieSession
        for (Promotion promotion : promotions) {
            kieSession.insert(promotion);
        }
        kieSession.setGlobal("rate",rate);

        kieSession.fireAllRules();
        kieSession.dispose();

        return this.CalculationPromotion(rate.getListRules(),applicantRequest.getTotalPrice());
    }

    public List<?> CalculationPromotion(List<Promotion> promotions , Double amount){

        TreeMap<Double, Double> ranges = new TreeMap<>();
        ranges.put(0.0, 150.0);
        ranges.put(50000.0, 125.0);
        ranges.put(100000.0, 100.0);
        ranges.put(200000.0, 50.0);
        ranges.put(500000.0, 55.0);
        ranges.put(2000000.0, 60.0);
        ranges.put(5000000.0, 70.0);
        ranges.put(Double.MAX_VALUE, 70.0);

        Double percentage = ranges.floorEntry(amount).getValue();

        System.out.println("Percentage: " + percentage);
        System.out.println("Amount: " + amount);

        List<PromotionAfterCalculation> potentialPromotions1 = new ArrayList<>();

        for(Promotion promotion : promotions){
            Double tienconlai = promotion.getCondition() - amount;
            System.out.println("tienconlai: " + tienconlai);

            int compareResult = tienconlai.compareTo(amount*(percentage/100));

            System.out.println("BBB: " + compareResult);
            PromotionAfterCalculation after = new PromotionAfterCalculation();

            double result = promotion.getValue() / Math.pow(tienconlai, 3) * Math.pow(10, 9);

            if(tienconlai > 0  &&  (compareResult < 0 || promotion.getCondition() <= 200000.0))
            {
                after.setId(promotion.getId());
                after.setName(promotion.getName());
                after.setDesc(promotion.getDesc());
                after.setStart(promotion.getStart());
                after.setEnd(promotion.getEnd());
                after.setValue(promotion.getValue());
                after.setCondition(promotion.getCondition());
                after.setResult(result);
                potentialPromotions1.add(after);
            }
        }

        potentialPromotions1.sort(Comparator.comparing(PromotionAfterCalculation::getResult,Comparator.reverseOrder()));
        return new ArrayList<>(potentialPromotions1);
    }

}
