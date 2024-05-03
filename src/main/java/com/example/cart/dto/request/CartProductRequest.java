package com.example.cart.dto.request;

import com.example.cart.global.domain.entity.CartOption;
import com.example.cart.global.domain.entity.CartProduct;

import java.util.Arrays;
import java.util.List;

public record CartProductRequest(
        Long userId,
        String productImage,
        String productName,
        Integer productPrice,
        Integer productQty,
        String productSeller,
        Integer productDelivery,
        CartOptionRequest[] cartOption
) {
    public CartProduct toEntity(Long userId) {
        return new CartProduct();
    }

    public CartProduct toEntity(Long cartProductId, Long userId) {
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
