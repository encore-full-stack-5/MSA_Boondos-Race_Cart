package com.example.cart.service;

import com.example.cart.dto.request.CartProductRequest;
import com.example.cart.dto.response.CartResponse;
import com.example.cart.global.domain.entity.CartProduct;
import com.example.cart.global.domain.repository.CartOptionRepository;
import com.example.cart.global.domain.repository.CartProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartProductRepository cartProductRepository;
    private final CartOptionRepository cartOptionRepository;

    @Override
    public List<CartResponse> getAllByUserId(UUID userId) {
        return cartProductRepository.findAllByUserId(userId)
                .stream().map(CartResponse::from).toList();
    }

    @Override
    @Transactional
    public void addProductByUserId(UUID userId, CartProductRequest req) {
        CartProduct cartProduct = req.toEntity(userId);
        cartProductRepository.save(cartProduct);
        cartOptionRepository.saveAll(req.getProductOptionList(cartProduct));
    }

    @Override
    @Transactional
    public void removeProductById(Long id) {
        cartProductRepository.deleteById(id);
    }

}
