package com.example.cart.global.domain.dto;

public record CartOptionDto(
    Long id,
    Long optionId,
    String optionName,
    Integer optionPrice
) {
}
