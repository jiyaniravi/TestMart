/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.constant;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
public class CommonConstants {

    private CommonConstants(){
        throw new UnsupportedOperationException("Can not instantiate CommonConstants. Invalid Operation!");
    }

    public static final String SITE_URL = "https://dummyjson.com";

    public static final String USERS_RESOURCE = SITE_URL+"/users";

    public static final String PRODUCTS_RESOURCE = SITE_URL+"/products";
    public static final String CATEGORIES_RESOURCE = PRODUCTS_RESOURCE+"/categories";
    public static final String PRODUCT_CATEGORY_RESOURCE = PRODUCTS_RESOURCE+"/category";

    public static final String CARTS_RESOURCE = SITE_URL+"/carts";
    public static final String USER_CARTS_RESOURCE = CARTS_RESOURCE+"/user";
}
