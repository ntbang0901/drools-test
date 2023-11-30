package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category", schema = "public", catalog = "promotion_fresher")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    private UUID categoryId;
    @Basic
    @Column(name = "category_name")
    private String categoryName;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<ProductEntity> productsByCategoryId;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<PromotionEntity> promotionsByCategoryId;

}
