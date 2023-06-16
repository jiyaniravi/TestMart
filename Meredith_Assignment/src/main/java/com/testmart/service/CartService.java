/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.service;

import java.util.List;

// Note: the generic type parameter T is used to represent the type of the cart.
public interface CartService<T> {

	/*
	 * Get all carts of TestMart
	 * API endpoint to get data: https://dummyjson.com/carts
	 */
	List<T> getAllCarts();

	/*
	 * Get a single cart
	 * API endpoint to get data: https://dummyjson.com/carts/{cartId}
	 */
	T getCart(Integer cartId);

	/*
	 * Get carts of a user
	 * API endpoint to get data: https://dummyjson.com/carts/user/{userIds}
	 */
	List<T> getUserCarts(Integer userId);
}
