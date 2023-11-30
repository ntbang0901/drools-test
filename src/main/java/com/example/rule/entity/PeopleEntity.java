package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "people", schema = "public", catalog = "promotion_fresher")
public class PeopleEntity {
    @Id
    @Column(name = "people_id")
    private UUID peopleId;
    @Basic
    @Column(name = "full_name")
    private String fullName;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "birth")
    private Date birth;
    @Basic
    @Column(name = "age_group")
    private String ageGroup;
    @Basic
    @Column(name = "job")
    private String job;
    @Basic
    @Column(name = "rank")
    private String rank;
    @Basic
    @Column(name = "first_time")
    private Boolean firstTime;
    @OneToMany(mappedBy = "peopleByPeopleId")
    private Collection<CartEntity> cartsByPeopleId;
    @OneToMany(mappedBy = "peopleByPeopleId")
    private Collection<PaymentEntity> paymentsByPeopleId;
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "place_id", nullable = false)
    private PlaceEntity placeByPlaceId;
    @OneToMany(mappedBy = "peopleByPeopleId")
    private Collection<PromotionEntity> promotionsByPeopleId;
    @OneToMany(mappedBy = "peopleByPeopleId")
    private Collection<PromotionPeopleEntity> promotionPeopleByPeopleId;
}
