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
@Table(name = "event", schema = "public", catalog = "promotion_fresher")
public class EventEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "event_id")
    private UUID eventId;
    @Basic
    @Column(name = "event_name")
    private String eventName;
    @Basic
    @Column(name = "event_type")
    private String eventType;
    @Basic
    @Column(name = "start")
    private Date start;
    @Basic
    @Column(name = "end")
    private Date end;
    @OneToMany(mappedBy = "eventByEventId")
    private Collection<TimeEntity> timesByEventId;
}
