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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "province", schema = "public", catalog = "promotion_fresher")
public class ProvinceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "province_id")
    private UUID provinceId;
    @Basic
    @Column(name = "province_name")
    private String provinceName;
    @OneToMany(mappedBy = "provinceByProvinceId")
    private Collection<PlaceEntity> placesByProvinceId;

}
