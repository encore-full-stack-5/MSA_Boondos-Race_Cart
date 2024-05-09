package com.example.cart.domain.dto.response;

import com.example.cart.domain.entity.CartProduct;

import java.util.List;

public record CartResponse(
        Long cartProductId,
        Long ProductID,
        String productImage,
        String productName,
        Integer productPrice,
        Integer productDiscount,
        Integer productQty,
        String productSeller,
        Integer productDelivery,

        List<CartOptionResponse> productOptions
) {
    public static CartResponse from(CartProduct cartProduct) {
        List<CartOptionResponse> cartOptions = cartProduct.getCartOptions().isEmpty() ? null :
                cartProduct.getCartOptions().stream().map(
                        cartOption -> new CartOptionResponse(
                                cartOption.getId(),
                                cartOption.getOptionGroupId(),
                                cartOption.getOptionGroupName(),
                                cartOption.getOptionId(),
                                cartOption.getOptionName(),
                                cartOption.getOptionPrice()
                        )
                ).toList();
        return new CartResponse(
                cartProduct.getId(),
                cartProduct.getProductId(),
                cartProduct.getProductImage(),
                cartProduct.getProductName(),
                cartProduct.getProductPrice(),
                cartProduct.getProductDiscount(),
                cartProduct.getProductQty(),
                cartProduct.getProductSeller(),
                cartProduct.getProductDelivery(),
                cartOptions
        );
    }
}
