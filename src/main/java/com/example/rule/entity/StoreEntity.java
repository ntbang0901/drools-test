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
@Table(name = "store", schema = "public", catalog = "promotion_fresher")
public class StoreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private UUID storeId;
    @Basic
    @Column(name = "store_name")
    private String storeName;
    @Basic
    @Column(name = "brand")
    private String brand;
    @Basic
    @Column(name = "scale")
    private String scale;
    @OneToMany(mappedBy = "storeByStoreId")
    private Collection<PlaceEntity> placesByStoreId;
}
