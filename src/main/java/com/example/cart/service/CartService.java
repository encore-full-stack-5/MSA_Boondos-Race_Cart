package com.example.cart.service;

import com.example.cart.dto.request.CartRequest;
import com.example.cart.dto.response.CartResponse;

import java.util.List;

public interface CartService {
    List<CartResponse> getAllByUserId(Long userId);
    void addProductByUserId(Long userId, CartRequest req);
    void removeProductByUserId(Long cartProductId);
}
