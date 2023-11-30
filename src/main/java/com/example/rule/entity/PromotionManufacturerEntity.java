package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
@Table(name = "promotion_manufacturer", schema = "public", catalog = "promotion_fresher")
public class PromotionManufacturerEntity {
    @Id
    @Column(name = "promotion_manufacturer_id")
    private UUID promotionManufacturerId;
    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "promotion_id", nullable = false)
    private PromotionEntity promotionByPromotionId;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "manufacturer_id", nullable = false)
    private ManufacturerEntity manufacturerByManufacturerId;
}
