/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.model;

import lombok.Data;

import java.util.List;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
@Data
public class Cart {
    private int id;
    private List<CartItem> products;
    private int total;
    private int discountedTotal;
    private int userId;
    private int totalProducts;
    private int totalQuantity;
}
