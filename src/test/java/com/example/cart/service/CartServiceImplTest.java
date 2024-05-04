package com.example.cart.service;

import com.example.cart.dto.request.CartOptionRequest;
import com.example.cart.dto.request.CartProductRequest;
import com.example.cart.dto.response.CartResponse;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
class CartServiceImplTest {
    @Autowired
    private EntityManager em;
    @Autowired
    private CartService cartService;

    @Test
    void addProductByUserId() {
        // give
        CartProductRequest req1 = new CartProductRequest(
                null,
                101L,
                "",
                "testName",
                10000,
                1,
                "testSeller",
                1000,
                new CartOptionRequest[]{
                        new CartOptionRequest(
                                1L,
                                "testOption1",
                                0
                        ),
                        new CartOptionRequest(
                                2L,
                                "testOption2",
                                2000
                        )
                }
        );
        CartProductRequest req2 = new CartProductRequest(
                null,
                102L,
                "",
                "testName2",
                7500,
                3,
                "testSeller2",
                0,
                new CartOptionRequest[]{}
        );

        // when
        cartService.addProductByUserId(1L, req1);
        cartService.addProductByUserId(2L, req2);
        em.flush();
        em.clear();

        // then
        List<CartResponse> res1 = cartService.getAllByUserId(1L);
        List<CartResponse> res2 = cartService.getAllByUserId(2L);
        Assertions.assertEquals(res1.size(), 1);
        Assertions.assertEquals(res1.get(0).productName(), "testName");
        Assertions.assertEquals(res1.get(0).productOptions().get(1).optionName(), "testOption2");
        Assertions.assertNull(res2.get(0).productOptions());
    }

    @Test
    void removeProductById() {
        // give
        CartProductRequest req = new CartProductRequest(
                null,
                101L,
                "",
                "testName",
                10000,
                1,
                "testSeller",
                1000,
                new CartOptionRequest[]{
                        new CartOptionRequest(
                                1L,
                                "testOption1",
                                0
                        ),
                        new CartOptionRequest(
                                2L,
                                "testOption2",
                                2000
                        )
                }
        );
        cartService.addProductByUserId(1L, req);
        em.flush();
        em.clear();

        // when
        cartService.removeProductById(1L);

        // then
        Assertions.assertEquals(cartService.getAllByUserId(1L).size(), 0);
    }
}