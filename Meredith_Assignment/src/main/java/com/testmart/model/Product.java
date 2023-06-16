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
public class Product extends CartItem {
    private String description;
    private float rating;
    private float stock;
    private String brand;
    private String category;
    private String thumbnail;
    private List<String> images;

    public Product(){}

    public Product(CartItem cartItem){
        this.id = cartItem.getId();
        this.title = cartItem.getTitle();
        this.price = cartItem.getPrice();
        this.quantity = cartItem.getQuantity();
        this.total = cartItem.getTotal();
        this.discountPercentage = cartItem.getDiscountPercentage();
        this.discountedPrice = cartItem.getDiscountedPrice();
    }
}
