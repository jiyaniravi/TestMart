/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.model;

import lombok.Data;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
@Data
public class CartItem {
    protected int id;
    protected String title;
    protected int price;
    protected int quantity=1;
    protected float discountPercentage;
    protected int discountedPrice;
    protected int total;

    protected CartItem(){
        this.total = this.getQuantity() * this.getPrice();
        this.discountedPrice = (int) (this.getTotal() - (this.getTotal() * this.getDiscountPercentage()/100));
    }
}
