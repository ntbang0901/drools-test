package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "time", schema = "public", catalog = "promotion_fresher")
public class TimeEntity {
    @Basic
    @Column(name = "day_in_week")
    private String dayInWeek;
    @Basic
    @Column(name = "start")
    private Date start;
    @Basic
    @Column(name = "end")
    private Date end;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "time_id")
    private UUID timeId;
    @OneToMany(mappedBy = "timeByTimeId")
    private Collection<CartEntity> cartsByTimeId;
    @OneToMany(mappedBy = "timeByTimeId")
    private Collection<PromotionEntity> promotionsByTimeId;
    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "event_id", nullable = false)
    private EventEntity eventByEventId;
}
