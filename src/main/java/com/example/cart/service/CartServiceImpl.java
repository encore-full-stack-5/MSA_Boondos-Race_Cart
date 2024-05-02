package com.example.cart.service;

import com.example.cart.dto.request.CartRequest;
import com.example.cart.dto.response.CartResponse;
import com.example.cart.global.domain.repository.CartOptionRepository;
import com.example.cart.global.domain.repository.CartProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartProductRepository productRepository;
    private final CartOptionRepository optionRepository;

    @Override
    public List<CartResponse> getAllByUserId(Long userId) {
        return List.of();
    }

    @Override
    @Transactional
    public void addProductByUserId(Long userId, CartRequest req) {

    }

    @Override
    @Transactional
    public void removeProductByUserId(Long cartProductId) {

    }
}
