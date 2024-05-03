package com.example.cart.dto.request;

public record CartOptionRequest(
        Long optionId,
        String optionName,
        Integer optionPrice
) {
}
