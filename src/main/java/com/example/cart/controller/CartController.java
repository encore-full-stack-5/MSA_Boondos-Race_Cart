package com.example.cart.controller;

import com.example.cart.dto.request.CartRequest;
import com.example.cart.dto.response.CartResponse;
import com.example.cart.global.domain.entity.CartProduct;
import com.example.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shopping/carts")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<CartResponse>getAllCartsByUserId(@RequestParam Long id){
        return cartService.getAllByUserId(id);
    }

    @PutMapping
    public void addCart(@RequestBody CartRequest cartRequest,
                        @RequestParam Long id){
        cartService.addProductByUserId(id, cartRequest);
    }

    @DeleteMapping
    public void deleteCart(@RequestParam Long id){
        cartService.removeProductByUserId(id);
    }
}
