package com.example.cart.controller;

import com.example.cart.dto.request.CartProductRequest;
import com.example.cart.dto.response.CartResponse;
import com.example.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shopping/carts")
public class CartController {
    private final CartService cartService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CartResponse>getAllCartsByUserId(@RequestParam Long id){
        return cartService.getAllByUserId(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCart(@RequestBody CartProductRequest cartProductRequest,
                        @RequestParam Long id){
        cartService.addProductByUserId(id, cartProductRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteCart(@RequestParam Long id){
        cartService.removeProductById(id);
    }
}
