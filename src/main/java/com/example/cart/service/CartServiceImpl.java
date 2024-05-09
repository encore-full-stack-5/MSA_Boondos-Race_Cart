package com.example.cart.service;

import com.example.cart.api.ApiAuth;
import com.example.cart.domain.dto.request.CartProductRequest;
import com.example.cart.domain.dto.response.CartResponse;
import com.example.cart.domain.entity.CartProduct;
import com.example.cart.domain.repository.CartOptionRepository;
import com.example.cart.domain.repository.CartProductRepository;
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
    private final ApiAuth apiAuth;

    @Override
    public List<CartResponse> getAllByUserId(String token) {
        UUID uuid = apiAuth.parseToken(token);
        return cartProductRepository.findAllByUserId(uuid)
                .stream().map(CartResponse::from).toList();
    }

    @Override
    @Transactional
    public void addProductByUserId(String token, CartProductRequest req) {
        UUID uuid = apiAuth.parseToken(token);
        CartProduct cartProduct = req.toEntity(uuid);
        cartProductRepository.save(cartProduct);
        cartOptionRepository.saveAll(req.getProductOptionList(cartProduct));
    }

    @Override
    @Transactional
    public void removeProductById(Long id) {
        cartProductRepository.deleteById(id);
    }

}
