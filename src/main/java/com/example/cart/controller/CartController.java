package com.example.cart.controller;

import com.example.cart.domain.dto.request.CartProductRequest;
import com.example.cart.domain.dto.response.CartResponse;
import com.example.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartController {
    private final CartService cartService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CartResponse>getAllCartsByUserId(@RequestParam String token){
        return cartService.getAllByUserId(token);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCart(@RequestBody CartProductRequest cartProductRequest,
                        @RequestParam String token){
        cartService.addProductByUserId(token, cartProductRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteCart(@RequestParam Long id){
        cartService.removeProductById(id);
    }
}
