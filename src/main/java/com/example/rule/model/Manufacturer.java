package com.example.rule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer implements Serializable {
    private UUID manufacturerId;
    private String manufacturerName;
}
