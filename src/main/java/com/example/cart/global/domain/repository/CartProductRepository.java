package com.example.cart.global.domain.repository;

import com.example.cart.global.domain.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CartProductRepository
    extends JpaRepository<CartProduct, Long> {
    List<CartProduct> findAllByUserId(UUID userId);
}
