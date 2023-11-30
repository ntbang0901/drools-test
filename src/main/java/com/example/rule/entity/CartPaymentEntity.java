package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data

@Entity
@Table(name = "cart_payment", schema = "public", catalog = "promotion_fresher")
public class CartPaymentEntity {
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", nullable = false)
    private CartEntity cartByCartId;
    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id", nullable = false)
    private PaymentEntity paymentByPaymentId;
    @Id
    @Column(name = "cart_payment_id")
    private UUID cartPaymentId;
}
