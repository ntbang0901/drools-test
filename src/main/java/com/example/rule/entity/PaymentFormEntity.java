package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment_form", schema = "public", catalog = "promotion_fresher")
public class PaymentFormEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "payment_form_id")
    private UUID paymentFormId;
    @Basic
    @Column(name = "payment_form_name")
    private String paymentFormName;
    @Basic
    @Column(name = "partner")
    private String partner;
    @Basic
    @Column(name = "prepay_amount")
    private BigInteger prepayAmount;
    @Basic
    @Column(name = "period")
    private short period;
    @Basic
    @Column(name = "rate")
    private Double rate;
    @OneToMany(mappedBy = "paymentFormByPaymentFormId")
    private Collection<PaymentEntity> paymentsByPaymentFormId;

}
