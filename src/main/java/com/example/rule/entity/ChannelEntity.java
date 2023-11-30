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
@Table(name = "channel", schema = "public", catalog = "promotion_fresher")
public class ChannelEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "channel_id")
    private UUID channelId;
    @Basic
    @Column(name = "channel_name")
    private String channelName;
    @Basic
    @Column(name = "brand")
    private String brand;
    @Basic
    @Column(name = "url")
    private String url;
    @OneToMany(mappedBy = "channelByChannelId")
    private Collection<PlaceEntity> placesByChannelId;

}
