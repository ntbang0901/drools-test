package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "promotion_item", schema = "public", catalog = "promotion_fresher")
public class PromotionItemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "promotion_item_id")
    private UUID promotionItemId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductEntity productByProductId;
    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "promotion_id")
    private PromotionEntity promotionByPromotionId;

}
