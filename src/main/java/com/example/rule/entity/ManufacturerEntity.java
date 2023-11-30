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
@Table(name = "manufacturer", schema = "public", catalog = "promotion_fresher")
public class ManufacturerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "manufacturer_id")
    private UUID manufacturerId;
    @Basic
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    @OneToMany(mappedBy = "manufacturerByManufacturerId")
    private Collection<ProductEntity> productsByManufacturerId;
    @OneToMany(mappedBy = "manufacturerByManufacturerId")
    private Collection<PromotionEntity> promotionsByManufacturerId;

    public ManufacturerEntity(UUID id) {
        this.manufacturerId = id;
    }

}
