package com.example.cart.domain.dto.response;

public record CartOptionResponse(
    Long id,
    Long optionGroupId,
    String optionGroupName,
    Long optionId,
    String optionName,
    Integer optionPrice
) {
}
