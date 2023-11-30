package com.example.rule.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product", schema = "public", catalog = "promotion_fresher")
public class ProductEntity {
    @Id
    @Column(name = "product_id")
    private String productId;
    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "price")
    private BigInteger price;

//    @Basic
//    @Column(name = "old_product_id")
//    private String oldProductId;
    @Basic
    @Column(name = "business_status")
    private String businessStatus;
    @Basic
    @Column(name = "product_status")
    private String productStatus;
    @Basic
    @Column(name = "color")
    private String color;
    @Basic
    @Column(name = "debut_date")
    private Date debutDate;
    @Basic
    @Column(name = "expiry_date")
    private Date expiryDate;

    @OneToMany(mappedBy = "productByProductId")
    private Collection<CartItemEntity> cartItemsByProductId;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "manufacturer_id", nullable = false)
    private ManufacturerEntity manufacturerByManufacturerId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private CategoryEntity categoryByCategoryId;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<PromotionItemEntity> promotionItemsByProductId;

}
