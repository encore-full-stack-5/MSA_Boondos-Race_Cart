package com.example.cart.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient("SHOPPING-AUTH-SERIVCE")
public interface FeignAuth {
    @GetMapping("api/v1/auth/parse")
    UUID parseToken(@RequestParam String token);
}
