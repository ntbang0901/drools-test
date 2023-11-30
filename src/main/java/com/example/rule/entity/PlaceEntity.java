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
@Table(name = "place", schema = "public", catalog = "promotion_fresher")
public class PlaceEntity {
    @Id
    @Column(name = "place_id")
    private UUID placeId;
    @OneToMany(mappedBy = "placeByPlaceId")
    private Collection<CartEntity> cartsByPlaceId;
    @OneToMany(mappedBy = "placeByPlaceId")
    private Collection<PeopleEntity> peopleByPlaceId;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    private StoreEntity storeByStoreId;
    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id", nullable = false)
    private RegionEntity regionByRegionId;
    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "province_id", nullable = false)
    private ProvinceEntity provinceByProvinceId;
    @ManyToOne
    @JoinColumns(@JoinColumn(name = "channel_id", referencedColumnName = "channel_id"))
    private ChannelEntity channelByChannelId;
    @OneToMany(mappedBy = "placeByPlaceId")
    private Collection<PromotionEntity> promotionsByPlaceId;
    @OneToMany(mappedBy = "placeByPlaceId")
    private Collection<PromotionPlaceEntity> promotionPlacesByPlaceId;
}
