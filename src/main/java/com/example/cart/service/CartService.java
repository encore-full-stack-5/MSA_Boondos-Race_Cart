package com.example.cart.service;

import com.example.cart.domain.dto.request.CartProductRequest;
import com.example.cart.domain.dto.request.CartUpdateRequest;
import com.example.cart.domain.dto.response.CartResponse;

import java.util.List;
import java.util.UUID;

public interface CartService {
    List<CartResponse> getAllByUserId( String token);
    void addProductByUserId( String token, CartProductRequest req);
    void removeProductById(Long id);
    void updateProductById(CartUpdateRequest req);
}
