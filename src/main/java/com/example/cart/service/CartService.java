package com.example.cart.service;

import com.example.cart.dto.request.CartProductRequest;
import com.example.cart.dto.response.CartResponse;

import java.util.List;

public interface CartService {
    List<CartResponse> getAllByUserId(Long userId);
    void addProductByUserId(Long userId, CartProductRequest req);
    void removeProductById(Long id);
}
