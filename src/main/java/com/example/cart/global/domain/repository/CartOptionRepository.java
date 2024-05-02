package com.example.cart.global.domain.repository;

import com.example.cart.global.domain.entity.CartOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartOptionRepository
    extends JpaRepository<CartOption, Long> {
}
