package com.example.cart.global.domain.repository;

import com.example.cart.global.domain.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository
    extends JpaRepository<CartProduct, Long> {
}
