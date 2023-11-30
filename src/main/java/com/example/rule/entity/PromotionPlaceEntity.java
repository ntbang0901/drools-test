package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
@Table(name = "promotion_place", schema = "public", catalog = "promotion_fresher")
public class PromotionPlaceEntity {
    @Id
    @Column(name = "promotion_place_id")
    private UUID promotionPlaceId;
    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "promotion_id", nullable = false)
    private PromotionEntity promotionByPromotionId;
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "place_id", nullable = false)
    private PlaceEntity placeByPlaceId;
}
