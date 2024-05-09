package com.example.cart.service;

import com.example.cart.domain.dto.request.CartOptionRequest;
import com.example.cart.domain.dto.request.CartProductRequest;
import com.example.cart.domain.dto.response.CartResponse;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@Transactional
class CartServiceImplTest {
    @Autowired
    private EntityManager em;
    @Autowired
    private CartService cartService;
/*
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
                1,
                "testSeller",
                1000,
                new CartOptionRequest[]{
                        new CartOptionRequest(
                                1L,
                                "testGroup1",
                                101L,
                                "testOption1",
                                0
                        ),
                        new CartOptionRequest(
                                2L,
                                "testGroup2",
                                201L,
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
                2,
                "testSeller2",
                0,
                new CartOptionRequest[]{}
        );

        // when
        cartService.addProductByUserId(UUID.fromString("00000000-0000-0000-0000-000000000001"), req1);
        cartService.addProductByUserId(UUID.fromString("00000000-0000-0000-0000-000000000002"), req2);
        em.flush();
        em.clear();

        // then
        List<CartResponse> res1 = cartService.getAllByUserId(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        List<CartResponse> res2 = cartService.getAllByUserId(UUID.fromString("00000000-0000-0000-0000-000000000002"));
        Assertions.assertEquals(1, res1.size());
        Assertions.assertEquals("testName", res1.get(0).productName());
        Assertions.assertEquals("testOption2", res1.get(0).productOptions().get(1).optionName());
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
                1,
                "testSeller",
                1000,
                new CartOptionRequest[]{
                        new CartOptionRequest(
                                1L,
                                "testGroup1",
                                101L,
                                "testOption1",
                                0
                        ),
                        new CartOptionRequest(
                                2L,
                                "testGroup2",
                                102L,
                                "testOption2",
                                2000
                        )
                }
        );
        cartService.addProductByUserId(UUID.fromString("00000000-0000-0000-0000-000000000001"), req);
        em.flush();
        em.clear();
        List<CartResponse> allByUserId = cartService.getAllByUserId(UUID.fromString("00000000-0000-0000-0000-000000000001"));

        // when
        cartService.removeProductById(allByUserId.get(0).cartProductId());

        // then
        Assertions.assertEquals(0, cartService.getAllByUserId(UUID.fromString("00000000-0000-0000-0000-000000000001")).size());
    }
 */
}