package com.example.cart.service;

import com.example.cart.dto.request.CartProductRequest;
import com.example.cart.dto.response.CartResponse;

import java.util.List;
import java.util.UUID;

public interface CartService {
    List<CartResponse> getAllByUserId(UUID userId);
    void addProductByUserId(UUID userId, CartProductRequest req);
    void removeProductById(Long id);
}
