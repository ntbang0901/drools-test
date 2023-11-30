package com.example.rule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {
    private UUID eventId;
    private String eventName;
    private String eventType;
    private Date start;
    private Date end;
}
