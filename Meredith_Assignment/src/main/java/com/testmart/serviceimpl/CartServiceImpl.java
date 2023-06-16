/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.serviceimpl;

import com.testmart.model.Cart;
import com.testmart.model.Carts;
import com.testmart.service.CartService;
import com.testmart.util.JacksonReaderUtil;
import com.testmart.util.OkHttpClientUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

import static com.testmart.constant.CommonConstants.CARTS_RESOURCE;
import static com.testmart.constant.CommonConstants.USER_CARTS_RESOURCE;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
public class CartServiceImpl implements CartService {

    private static final Logger LOG = LogManager.getLogger();

    @Override
    public List<Cart> getAllCarts() {
        LOG.debug("getAllCarts() called");
        String response = OkHttpClientUtil.getHttpRequest(CARTS_RESOURCE);
        Carts carts = JacksonReaderUtil.getObject(response, Carts.class);
        return (carts!=null)?carts.getCarts(): Collections.emptyList();
    }

    @Override
    public Cart getCart(Integer cartId) {
        LOG.debug("getCart() called with cartId={}",cartId);
        String response = OkHttpClientUtil.getHttpRequest(CARTS_RESOURCE+"/"+cartId);
        Cart cart = JacksonReaderUtil.getObject(response, Cart.class);
        return cart;
    }

    @Override
    public List<Cart> getUserCarts(Integer userId) {
        LOG.debug("getUserCarts() called with userId={}",userId);
        String response = OkHttpClientUtil.getHttpRequest(USER_CARTS_RESOURCE+"/"+userId);
        Carts carts = JacksonReaderUtil.getObject(response, Carts.class);
        return (carts!=null)?carts.getCarts(): Collections.emptyList();
    }
}
