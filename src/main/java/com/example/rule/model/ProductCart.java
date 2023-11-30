package com.example.rule.model;

import com.example.rule.entity.CartEntity;
import com.example.rule.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCart {
    private int quantity;
    private UUID cartItemId;
    private String productId;
    private String cartByCartId;
}
