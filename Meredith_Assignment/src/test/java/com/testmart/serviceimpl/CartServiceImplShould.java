/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.serviceimpl;

import com.testmart.model.Cart;
import com.testmart.service.CartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
public class CartServiceImplShould {

    @Test
    public void returnAllCarts(){
    // Given
        CartService cartService = getCartServiceInstance();
    // When
        List<Cart> carts = cartService.getAllCarts();
    // Then
        Assertions.assertNotNull(carts);
        Assertions.assertTrue(carts.size()>0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void returnCorrectProduct_forGivenUserId(int cartId){
    // Given
        CartService cartService = getCartServiceInstance();
    // When
        Cart cart = (Cart) cartService.getCart(cartId);
    // Then
        Assertions.assertNotNull(cart);
        Assertions.assertEquals(cartId, cart.getId());
    }

    private static Stream<Object[]> cartDataProvider() {
        return Stream.of(
                new Object[]{1, 1},
                       new Object[]{2, 0}
        );
    }

    @ParameterizedTest
    @MethodSource("cartDataProvider")
    public void returnCorrectCarts_asPerUserId(int userId, int count){
    // Given
        CartService cartService = getCartServiceInstance();
    // When
        List<Cart> carts = cartService.getUserCarts(userId);
    // Then
        Assertions.assertNotNull(carts);
        Assertions.assertEquals(count, carts.size());
    }

    private static CartService getCartServiceInstance(){
        return new CartServiceImpl();
    }
}
