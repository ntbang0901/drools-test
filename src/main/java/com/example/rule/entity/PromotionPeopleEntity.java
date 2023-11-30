package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
@Table(name = "promotion_people", schema = "public", catalog = "promotion_fresher")
public class PromotionPeopleEntity {
    @Id
    @Column(name = "promotion_people_id")
    private UUID promotionPeopleId;
    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "promotion_id", nullable = false)
    private PromotionEntity promotionByPromotionId;
    @ManyToOne
    @JoinColumn(name = "people_id", referencedColumnName = "people_id", nullable = false)
    private PeopleEntity peopleByPeopleId;
}
