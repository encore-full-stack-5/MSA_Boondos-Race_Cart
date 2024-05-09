package com.example.cart.api;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ApiAuth {
    private final FeignAuth feignAuth;

    @Async
    public UUID parseToken(String token) {
        return feignAuth.parseToken(token);
    }
}
