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
@Table(name = "payment", schema = "public", catalog = "promotion_fresher")
public class PaymentEntity {
    @Basic
    @Column(name = "partner")
    private String partner;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "payment_id")
    private UUID paymentId;
    @OneToMany(mappedBy = "paymentByPaymentId")
    private Collection<CartEntity> cartsByPaymentId;
    @ManyToOne
    @JoinColumn(name = "people_id", referencedColumnName = "people_id", nullable = false)
    private PeopleEntity peopleByPeopleId;
    @ManyToOne
    @JoinColumn(name = "payment_form_id", referencedColumnName = "payment_form_id", nullable = false)
    private PaymentFormEntity paymentFormByPaymentFormId;
    @ManyToOne
    @JoinColumn(name = "payment_method_id", referencedColumnName = "payment_method_id", nullable = false)
    private PaymentMethodEntity paymentMethodByPaymentMethodId;
    @OneToMany(mappedBy = "paymentByPaymentId")
    private Collection<PromotionEntity> promotionsByPaymentId;

}
