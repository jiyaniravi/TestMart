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
public class Carts {
    private List<Cart> carts;
    private int total;
    private int skip;
    private int limit;
}
