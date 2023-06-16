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
public class Address {
    private String address;
    private String city;
    private LocationCoordinates coordinates;
    private String postalCode;
    private String state;
}
