package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
@Table(name = "promotion_category", schema = "public", catalog = "promotion_fresher")
public class PromotionCategoryEntity {
    @Id
    @Column(name = "promotion_category_id")
    private UUID promotionCategoryId;
    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "promotion_id", nullable = false)
    private PromotionEntity promotionByPromotionId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private CategoryEntity categoryByCategoryId;
}
