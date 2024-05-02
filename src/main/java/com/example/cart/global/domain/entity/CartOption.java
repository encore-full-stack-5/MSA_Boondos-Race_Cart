package com.example.cart.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CART_OPTIONS")
@Builder
public class CartOption {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_OPTION_ID")
    private Long id;

    @Column(name = "OPTION_ID", nullable = false)
    private Long optionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CART_PRODUCT_ID", nullable = false)
    private CartProduct cartProduct;

    @Column(name = "OPTION_NAME", nullable = false)
    private String optionName;

    @Column(name = "OPTION_PRICE", nullable = false)
    private Integer optionPrice;
}
