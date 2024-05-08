package com.example.cart.dto.request;

import com.example.cart.global.domain.entity.CartOption;
import com.example.cart.global.domain.entity.CartProduct;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public record CartProductRequest(
        UUID userId,
        Long productId,
        String productImage,
        String productName,
        Integer productPrice,
        Integer productQty,
        String productSeller,
        Integer productDelivery,
        CartOptionRequest[] cartOption
) {
    public CartProduct toEntity(UUID userId) {
        return CartProduct.builder()
                .userId(userId)
                .productId(productId)
                .productImage(productImage)
                .productName(productName)
                .productPrice(productPrice)
                .productQty(productQty)
                .productSeller(productSeller)
                .productDelivery(productDelivery)
                .build();
    }

    public CartProduct toEntity(Long cartProductId, UUID userId) {
        return new CartProduct();
    }

    public List<CartOption> getProductOptionList(CartProduct cartProduct) {
        return Arrays.stream(this.cartOption).map(e ->
                    CartOption.builder()
                            .cartProduct(cartProduct)
                            .optionId(e.optionId())
                            .optionName(e.optionName())
                            .optionPrice(e.optionPrice())
                            .build())
                .toList();
    }
}
