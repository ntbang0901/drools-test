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
@Table(name = "cart", schema = "public", catalog = "promotion_fresher")
public class CartEntity {
    @Basic
    @Column(name = "total_price")
    private BigInteger totalPrice;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cart_id")
    private UUID cartId;

    @ManyToOne
    @JoinColumn(name = "people_id", referencedColumnName = "people_id", nullable = false)
    private PeopleEntity peopleByPeopleId;
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "place_id", nullable = false)
    private PlaceEntity placeByPlaceId;
    @ManyToOne
    @JoinColumn(name = "time_id", referencedColumnName = "time_id", nullable = false)
    private TimeEntity timeByTimeId;
    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id", nullable = false)
    private PaymentEntity paymentByPaymentId;
    @OneToMany(mappedBy = "cartByCartId")
    private Collection<CartItemEntity> cartItemsByCartId;
}
