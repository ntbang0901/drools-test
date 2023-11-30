package com.example.rule.model;

import com.example.rule.entity.CartItemEntity;
import com.example.rule.entity.PromotionItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private String productId;
    private String productName;

    private BigInteger price;

    private String businessStatus;

    private String productStatus;
    private String color;
    private Date debutDate;
    private Date expiryDate;

    private Collection<CartItemEntity> cartItemsByProductId;
    private UUID manufacturerByManufacturerId;
    private UUID categoryByCategoryId;
    private Collection<PromotionItemEntity> promotionItemsByProductId;
}
