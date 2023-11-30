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
@Table(name = "region", schema = "public", catalog = "promotion_fresher")
public class RegionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "region_id")
    private UUID regionId;
    @Basic
    @Column(name = "region_name")
    private String regionName;
    @OneToMany(mappedBy = "regionByRegionId")
    private Collection<PlaceEntity> placesByRegionId;

}
