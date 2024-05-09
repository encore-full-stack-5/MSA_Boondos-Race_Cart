package com.example.cart.domain.dto.request;

public record CartOptionRequest(
        Long optionGroupId,
        String optionGroupName,
        Long optionId,
        String optionName,
        Integer optionPrice
) {
}
