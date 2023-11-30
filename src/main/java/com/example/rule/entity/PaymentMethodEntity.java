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
@Table(name = "payment_method", schema = "public", catalog = "promotion_fresher")
public class PaymentMethodEntity {
    @Id
    @Column(name = "payment_method_id")
    private UUID paymentMethodId;
    @Basic
    @Column(name = "payment_method_name")
    private String paymentMethodName;
    @Basic
    @Column(name = "partner")
    private String partner;
    @OneToMany(mappedBy = "paymentMethodByPaymentMethodId")
    private Collection<PaymentEntity> paymentsByPaymentMethodId;
}
