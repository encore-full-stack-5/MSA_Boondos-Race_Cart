package com.example.cart.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CART_PRODUCTS")
@Builder
public class CartProduct {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "USER_ID", nullable = false)
    private UUID userId;

    @Column(name = "PRODUCT_IMAGE", nullable = false)
    private String productImage;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "PRODUCT_PRICE", nullable = false)
    private Integer productPrice;

    @Column(name = "PRODUCT_QTY", nullable = false)
    private Integer productQty;

    @Column(name = "PRODUCT_SELLER", nullable = false)
    private String productSeller;

    @Column(name = "PRODUCT_DELIVERY", nullable = false)
    private Integer productDelivery;


    @OneToMany(mappedBy = "cartProduct", cascade = CascadeType.REMOVE)
    private List<CartOption> cartOptions;
}
