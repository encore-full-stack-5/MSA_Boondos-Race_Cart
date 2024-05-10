package com.example.cart.domain.dto.request;

import com.example.cart.domain.entity.CartProduct;

public record CartUpdateRequest (
        String productName,
        Integer productPrice,
        Integer productDiscount,
        Integer productDelivery
){
    public CartProduct toEntity(Long id) {
        return CartProduct.builder()
                .id(id)
                .productName(productName)
                .productPrice(productPrice)
                .productDiscount(productDiscount)
                .productDelivery(productDelivery)
                .build();
    }
}
