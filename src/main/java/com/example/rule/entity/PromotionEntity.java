package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "promotion", schema = "public", catalog = "promotion_fresher")
public class PromotionEntity {
    @Id
    @Column(name = "promotion_id")
    private UUID promotionId;
    @Basic
    @Column(name = "promotion_name")
    private String promotionName;
    @Basic
    @Column(name = "discount_type")
    private String discountType;
    @Basic
    @Column(name = "discount_value")
    private int discountValue;
    @Basic
    @Column(name = "minimum_price")
    private BigInteger minimumPrice;
    @Basic
    @Column(name = "promotion_type")
    private String promotionType;
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "place_id",nullable = true)
    private PlaceEntity placeByPlaceId;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "manufacturer_id", nullable = true)
    private ManufacturerEntity manufacturerByManufacturerId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = true)
    private CategoryEntity categoryByCategoryId;
    @ManyToOne
    @JoinColumn(name = "time_id", referencedColumnName = "time_id")
    private TimeEntity timeByTimeId;
    @ManyToOne
    @JoinColumn(name = "people_id", referencedColumnName = "people_id" , nullable = true)
    private PeopleEntity peopleByPeopleId;
    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id", nullable = true)
    private PaymentEntity paymentByPaymentId;
    @OneToMany(mappedBy = "promotionByPromotionId")
    private Collection<PromotionItemEntity> promotionItemsByPromotionId;
    @OneToMany(mappedBy = "promotionByPromotionId")
    private Collection<PromotionPaymentEntity> promotionPaymentsByPromotionId;
    @OneToMany(mappedBy = "promotionByPromotionId")
    private Collection<PromotionPeopleEntity> promotionPeopleByPromotionId;
    @OneToMany(mappedBy = "promotionByPromotionId")
    private Collection<PromotionPlaceEntity> promotionPlacesByPromotionId;
    @OneToMany(mappedBy = "promotionByPromotionId")
    private Collection<PromotionCategoryEntity> promotionCategoriesByPromotionId;
    @OneToMany(mappedBy = "promotionByPromotionId")
    private Collection<PromotionManufacturerEntity> promotionManufacturersByPromotionId;
}
