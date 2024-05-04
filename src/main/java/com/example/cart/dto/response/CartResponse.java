package com.example.cart.dto.response;

import com.example.cart.global.domain.dto.CartOptionDto;
import com.example.cart.global.domain.entity.CartProduct;

import java.util.List;

public record CartResponse(
        Long cartProductId,
        Long ProductID,
        String productImage,
        String productName,
        Integer productPrice,
        Integer productQty,
        String productSeller,
        Integer productDelivery,

        List<CartOptionDto> productOptions
) {
    public static CartResponse from(CartProduct cartProduct) {
        List<CartOptionDto> cartOptions = cartProduct.getCartOptions().isEmpty() ? null :
                cartProduct.getCartOptions().stream().map(
                        cartOption -> new CartOptionDto(
                                cartOption.getId(),
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
                cartProduct.getProductQty(),
                cartProduct.getProductSeller(),
                cartProduct.getProductDelivery(),
                cartOptions
        );
    }
}
