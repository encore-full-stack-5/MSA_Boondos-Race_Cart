package com.example.cart.domain.repository;

import com.example.cart.domain.entity.CartOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartOptionRepository
    extends JpaRepository<CartOption, Long> {
}
